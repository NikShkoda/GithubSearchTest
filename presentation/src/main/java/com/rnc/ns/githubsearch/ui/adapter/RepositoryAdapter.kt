package com.rnc.ns.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.rnc.ns.githubsearch.R
import com.rnc.ns.githubsearch.databinding.ViewItemRepositoryBinding
import com.rnc.ns.githubsearch.extension.toRating
import com.rnc.ns.githubsearch.model.GithubRepo

class RepositoryAdapter(private val _onItemClick: (repo: GithubRepo) -> Unit) :
    BasePagingDataAdapter<Long, GithubRepo, ViewItemRepositoryBinding>() {
    override val bindingInflater =
        { inflater: LayoutInflater, viewGroup: ViewGroup?, attachToRoot: Boolean ->
            ViewItemRepositoryBinding.inflate(inflater, viewGroup, attachToRoot)
        }

    override fun bind(data: GithubRepo, binding: ViewItemRepositoryBinding) {
        with(binding) {
            tvRepositoryName.text = data.name
            Glide.with(root.context).load(data.owner.avatarUrl).circleCrop().into(binding.ivOwnerAvatar)
            rbRepositoryStars.rating = data.score().toRating()
            tvRepositoryStars.text = binding.root.context.getString(R.string.format_stars, data.stars)
            root.setOnClickListener {
                _onItemClick.invoke(data)
            }
        }
    }
}