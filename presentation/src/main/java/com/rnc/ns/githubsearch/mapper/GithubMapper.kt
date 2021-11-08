package com.rnc.ns.githubsearch.mapper

import com.rnc.ns.githubsearch.model.GithubRepo
import com.rnc.ns.githubsearch.model.Owner

object GithubMapper {
    fun com.rnc.ns.domain.model.github.GithubRepo.toGithubRepo(): GithubRepo =
        GithubRepo(id, name, description, url, stars, watchers, owner.toOwner())

    private fun com.rnc.ns.domain.model.github.Owner.toOwner(): Owner =
        Owner(login, avatarUrl)
}