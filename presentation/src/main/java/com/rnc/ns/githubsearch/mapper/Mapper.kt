package com.rnc.ns.githubsearch.mapper

import com.rnc.ns.domain.model.github.GithubRepo
import com.rnc.ns.domain.model.github.Owner
import com.rnc.ns.githubsearch.model.GithubRepoModel
import com.rnc.ns.githubsearch.model.OwnerModel

fun GithubRepo.toGithubRepoModel(): GithubRepoModel =
    GithubRepoModel(id, name, description, url, stars, watchers, stars + watchers, owner.toOwner())

private fun Owner.toOwner(): OwnerModel =
    OwnerModel(login, avatarUrl)