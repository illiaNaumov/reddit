package com.naumov.reddit.domain

import com.naumov.reddit.domain.model.Listing
import io.reactivex.Single

class GetPostsUseCase(
    private val postRepository: PostRepository
) {

    fun execute(limit: Int): Single<Listing> {
        return postRepository.getTopPosts(limit)
    }
}