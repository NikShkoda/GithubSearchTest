package com.rnc.ns.githubsearch.ui.repository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rnc.ns.githubsearch.R
import com.rnc.ns.githubsearch.databinding.FragmentRepositoriesBinding
import com.rnc.ns.githubsearch.extension.hide
import com.rnc.ns.githubsearch.extension.hideKeyboard
import com.rnc.ns.githubsearch.extension.show
import com.rnc.ns.githubsearch.extension.string
import com.rnc.ns.githubsearch.model.GithubRepo
import com.rnc.ns.githubsearch.ui.adapter.RepositoryAdapter
import com.rnc.ns.githubsearch.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RepositoriesFragment : BaseFragment<FragmentRepositoriesBinding>() {
    private val _viewModel: RepositoriesViewModel by viewModels()

    override val bindingInflater =
        { inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean ->
            FragmentRepositoriesBinding.inflate(inflater, container, attachToRoot)
        }

    private val repositoryAdapter by lazy {
        RepositoryAdapter {
            showDetails(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etSearch.setOnEditorActionListener { textView, actionId, _ ->
            when (actionId) {
                EditorInfo.IME_ACTION_SEARCH -> {
                    textView.string().let {
                        if (it.isEmpty()) {
                            showMessage(getString(R.string.empty_search))
                            return@setOnEditorActionListener false
                        }
                        getData(it)
                    }
                    binding.etSearch.hideKeyboard()
                    true
                }
                else -> false
            }
        }

        binding.rvRepositories.apply {
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
            adapter = repositoryAdapter
            if (repositoryAdapter.itemCount == 0) {
                binding.tvNoData.show()
            }
        }
    }

    private fun getData(searchString: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            repositoryAdapter.loadStateFlow.collectLatest {
                when (it.refresh) {
                    is LoadState.Error -> {
                        val errorText = (it.refresh as LoadState.Error).error.message
                            ?: getString(R.string.unknown_error)
                        showMessage(errorText)
                        binding.cpProgress.hide()
                        binding.tvNoData.show()
                        binding.rvRepositories.hide()
                    }
                    is LoadState.Loading -> {
                        binding.cpProgress.show()
                    }
                    is LoadState.NotLoading -> {
                        if (repositoryAdapter.itemCount > 0) {
                            binding.tvNoData.hide()
                            binding.rvRepositories.show()
                        }
                        binding.cpProgress.hide()
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            _viewModel.search(searchString).collectLatest {
                repositoryAdapter.submitData(viewLifecycleOwner.lifecycle, it)
            }
        }
    }

    private fun showDetails(repository: GithubRepo) {
        navController.navigate(R.id.action_Repositories_to_RepositoryDetails, Bundle().apply {
            putParcelable(RepositoryDetailsFragment.EXTRA_REPOSITORY, repository)
        })
    }

}