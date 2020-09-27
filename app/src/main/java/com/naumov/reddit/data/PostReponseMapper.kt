package com.naumov.reddit.data

import com.naumov.reddit.data.response.ListingResponse
import com.naumov.reddit.data.response.PostWrapperResponse
import com.naumov.reddit.domain.model.Listing
import com.naumov.reddit.domain.model.Post
import java.util.*

class PostResponseMapper {
    fun map(response: ListingResponse): Listing {
        return Listing(
            limit = response.limit,
            posts = mapPosts(response.posts)
        )
    }

    private fun mapPosts(wrappers: List<PostWrapperResponse>): List<Post> {
        return wrappers.map {
            val postResponse = it.post
            Post(
                id = postResponse.id,
                title = postResponse.title,
                author = postResponse.author,
                date = formatCreationDate(postResponse.createdSec),
                thumbnail = postResponse.url,
                commentCount = postResponse.commentCount
            )
        }
    }

    private fun formatCreationDate(time: Double): Date {
        return Date((time * 1000).toLong())
    }
}