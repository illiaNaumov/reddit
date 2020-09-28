package com.naumov.reddit.data.response

import com.google.gson.annotations.SerializedName

class PreviewResponse(
    @SerializedName("images") val images: List<ImageResponse>
)

class ImageResponse(
    @SerializedName("source") val source: ImageSource
)

class ImageSource(
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int
)