package com.naumov.reddit.domain

import com.naumov.reddit.domain.model.Listing

interface PostRepository {
    suspend fun getTopPostsAsync(limit: Int, nextKey: String?): Listing
}