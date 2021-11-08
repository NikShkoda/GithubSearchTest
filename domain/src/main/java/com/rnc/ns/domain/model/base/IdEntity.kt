package com.rnc.ns.domain.model.base

interface IdEntity<T> {
    val id: T
    override fun equals(other: Any?): Boolean
}