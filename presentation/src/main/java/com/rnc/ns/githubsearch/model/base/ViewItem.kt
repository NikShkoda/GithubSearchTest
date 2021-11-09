package com.rnc.ns.githubsearch.model.base

interface ViewItem<T> {
    val id: T
    override fun equals(other: Any?): Boolean
}