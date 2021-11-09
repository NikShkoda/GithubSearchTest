package com.rnc.ns.githubsearch.ui.repository

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.rnc.ns.domain.usecase.GetGithubReposUseCase
import com.rnc.ns.githubsearch.manager.ScoreManager
import com.rnc.ns.githubsearch.model.GithubRepoViewItem
import com.rnc.ns.githubsearch.source.GithubRepoPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase
) : ViewModel() {
    fun search(searchString: String, pageSize: Int = 10): Flow<PagingData<GithubRepoViewItem>> {
        return Pager(PagingConfig(pageSize)) {
            ScoreManager.resetMaxScore()
            GithubRepoPagingSource(getGithubReposUseCase, searchString)
        }.flow
    }

}