package com.naumov.reddit.data.response

import com.google.gson.annotations.SerializedName

class ListingResponse(
    @SerializedName("children") val posts: List<PostWrapperResponse>,
    @SerializedName("after") val after: String?,
)