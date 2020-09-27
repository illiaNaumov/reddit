package com.naumov.reddit.data.response

import com.google.gson.annotations.SerializedName

class PostWrapperResponse(
    @SerializedName("data") val post: PostResponse
)