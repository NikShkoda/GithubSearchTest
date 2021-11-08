package com.rnc.ns.githubsearch.model

interface IdModel<T> {
    val id: T
    override fun equals(other: Any?): Boolean
}