package com.naumov.reddit.data.response

import com.google.gson.annotations.SerializedName

class PostResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("url") val url: String,
    @SerializedName("created") val createdSec: Double,
    @SerializedName("author") val author: String,
    @SerializedName("num_comments") val commentCount: Int,
    @SerializedName("preview") val preview: PreviewResponse?
)