package com.naumov.reddit.data

import android.util.Log
import androidx.paging.PagingSource
import com.naumov.reddit.domain.PostRepository
import com.naumov.reddit.domain.model.Post

class RedditPagingSource(
    private val postRepository: PostRepository
) : PagingSource<String, Post>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Post> {
        return try {
            val response = postRepository.getTopPostsAsync(params.loadSize, params.key)
            LoadResult.Page(
                data = response.posts,
                prevKey = null,
                nextKey = response.after,
            )
        } catch (e: Exception) {
            Log.e("Paging", e.localizedMessage ?: "")
            LoadResult.Error(e)
        }
    }
}