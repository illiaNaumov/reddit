package com.naumov.reddit.domain

import com.naumov.reddit.domain.model.Listing
import io.reactivex.Single

interface PostRepository {
    fun getTopPosts(limit: Int): Single<Listing>
}