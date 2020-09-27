package com.naumov.reddit.data

import com.naumov.reddit.data.response.RedditResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {

    @GET("top.json")
    suspend fun getTopPostsAsync(
        @Query("limit") limit: Int,
        @Query("after") nextKey: String?
    ): RedditResponse
}