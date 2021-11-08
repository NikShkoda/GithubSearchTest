package com.rnc.ns.githubsearch.ui.repository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.rnc.ns.githubsearch.R
import com.rnc.ns.githubsearch.databinding.FragmentRepositoryDetailsBinding
import com.rnc.ns.githubsearch.model.GithubRepoModel
import com.rnc.ns.githubsearch.ui.base.BaseFragment

class RepositoryDetailsFragment : BaseFragment<FragmentRepositoryDetailsBinding>() {
    companion object {
        const val EXTRA_REPOSITORY = "extra_repository"
    }

    override val bindingInflater =
        { inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean ->
            FragmentRepositoryDetailsBinding.inflate(inflater, container, attachToRoot)
        }

    private val _repo by lazy {
        arguments?.getParcelable(EXTRA_REPOSITORY) as GithubRepoModel?
            ?: throw IllegalStateException("Repository can't be null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(_repo) {
            binding.tvRepositoryName.text = getString(R.string.format_repository_name, name)
            Glide.with(requireContext()).load(ownerModel.avatarUrl).circleCrop().into(binding.ivOwnerAvatar)
            binding.rbRepositoryStars.rating = score().toRating()
            binding.tvDescription.text = getString(R.string.format_description, description)
            binding.tvRepositoryUrl.text = getString(R.string.format_repository_url, url)
            binding.tvRepositoryStars.text = getString(R.string.format_stars, stars)
        }
    }

}