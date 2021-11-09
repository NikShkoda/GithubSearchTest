package com.rnc.ns.githubsearch.mapper

import com.rnc.ns.domain.model.github.GithubRepoModelItem
import com.rnc.ns.domain.model.github.OwnerModelItem
import com.rnc.ns.githubsearch.model.GithubRepoViewItem
import com.rnc.ns.githubsearch.model.OwnerViewItem

fun GithubRepoModelItem.toGithubRepoModel(): GithubRepoViewItem =
    GithubRepoViewItem(id, name, description, url, stars, watchers, stars + watchers, ownerModelItem.toOwner())

private fun OwnerModelItem.toOwner(): OwnerViewItem =
    OwnerViewItem(login, avatarUrl)