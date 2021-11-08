package com.rnc.ns.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.rnc.ns.githubsearch.R
import com.rnc.ns.githubsearch.databinding.ViewItemRepositoryBinding
import com.rnc.ns.githubsearch.extension.toRating
import com.rnc.ns.githubsearch.model.GithubRepoModel

class RepositoryAdapter(private val onItemClick: (repoModel: GithubRepoModel) -> Unit) :
    BasePagingDataAdapter<Long, GithubRepoModel, ViewItemRepositoryBinding>() {
    override val bindingInflater =
        { inflater: LayoutInflater, viewGroup: ViewGroup?, attachToRoot: Boolean ->
            ViewItemRepositoryBinding.inflate(inflater, viewGroup, attachToRoot)
        }

    override fun bind(data: GithubRepoModel, binding: ViewItemRepositoryBinding) {
        with(binding) {
            tvRepositoryName.text = data.name
            Glide.with(root.context).load(data.ownerModel.avatarUrl).circleCrop().into(binding.ivOwnerAvatar)
            rbRepositoryStars.rating = data.score.toRating()
            tvRepositoryStars.text = binding.root.context.getString(R.string.format_stars, data.stars)
            root.setOnClickListener {
                onItemClick.invoke(data)
            }
        }
    }
}