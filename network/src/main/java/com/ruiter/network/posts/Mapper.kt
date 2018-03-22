package com.ruiter.network.posts

/**
 * Created by ruitermatos on 21/03/18.
 */
interface Mapper<in M, out N> {
    fun mapFromNetwork(type: M): N
}