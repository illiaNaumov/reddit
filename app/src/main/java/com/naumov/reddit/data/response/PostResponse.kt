package com.naumov.reddit.data.response

import com.google.gson.annotations.SerializedName

class PostResponse(
    @SerializedName("id") val id: String, //izo1nm
    @SerializedName("title") val title: String, //TV Channels: Then &amp; Now
    @SerializedName("thumbnail") val url: String, //https://i.redd.it/p4imq42qybp51.png
    @SerializedName("created") val createdSec: Double, //1601055592.0
    @SerializedName("author") val author: String, //matts41
    @SerializedName("num_comments") val commentCount: Int,
    @SerializedName("preview") val preview: PreviewResponse?
)