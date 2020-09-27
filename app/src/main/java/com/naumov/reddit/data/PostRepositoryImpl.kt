package com.naumov.reddit.data

import com.naumov.reddit.domain.PostRepository
import com.naumov.reddit.domain.model.Listing

class PostRepositoryImpl(
    private val redditApi: RedditApi,
    private val postResponseMapper: PostResponseMapper
) : PostRepository {

    override suspend fun getTopPostsAsync(limit: Int, nextKey: String?): Listing {
        val listingResponse = redditApi.getTopPostsAsync(limit, nextKey)
        return postResponseMapper.map(listingResponse.listing)
    }
}