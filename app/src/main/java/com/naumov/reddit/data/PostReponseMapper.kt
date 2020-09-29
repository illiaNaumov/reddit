package com.naumov.reddit.data

import com.naumov.reddit.data.response.ListingResponse
import com.naumov.reddit.data.response.PostWrapperResponse
import com.naumov.reddit.data.response.PreviewResponse
import com.naumov.reddit.domain.model.Listing
import com.naumov.reddit.domain.model.Post
import com.naumov.reddit.domain.model.Preview
import java.util.*

class PostResponseMapper {
    fun map(response: ListingResponse): Listing {
        return Listing(
            posts = mapPosts(response.posts),
            after = response.after
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
                url = postResponse.url,
                commentCount = postResponse.commentCount,
                preview = postResponse.preview?.let { mapPreview(it) },
                thumbnail = postResponse.thumbnail
            )
        }
    }

    private fun mapPreview(previewResponse: PreviewResponse): Preview {
        val imageSource = previewResponse.images.first().source
        val decodedPreviewUrl =
            imageSource.url.replace("&amp;", "&")
        return Preview(
            url = decodedPreviewUrl,
            width = imageSource.width,
            height = imageSource.height
        )
    }

    private fun formatCreationDate(time: Double): Date {
        return Date((time * 1000).toLong())
    }
}