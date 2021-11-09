package com.rnc.ns.domain.model.base

interface ModelItem<T> {
    val id: T
    override fun equals(other: Any?): Boolean
}