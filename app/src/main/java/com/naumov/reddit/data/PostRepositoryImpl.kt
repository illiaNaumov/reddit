package com.naumov.reddit.data

import com.naumov.reddit.domain.PostRepository
import com.naumov.reddit.domain.model.Listing
import io.reactivex.Single

class PostRepositoryImpl(
    private val redditApi: RedditApi,
    private val postResponseMapper: PostResponseMapper
) : PostRepository {

    override fun getTopPosts(limit: Int): Single<Listing> {
        return redditApi.getTopPosts(limit).map {
            postResponseMapper.map(it.listing)
        }
    }
}