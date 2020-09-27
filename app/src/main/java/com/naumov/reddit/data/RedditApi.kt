package com.naumov.reddit.data

import com.naumov.reddit.data.response.RedditResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {

    @GET("top.json")
    fun getTopPosts(@Query("limit") limit: Int): Single<RedditResponse>
}