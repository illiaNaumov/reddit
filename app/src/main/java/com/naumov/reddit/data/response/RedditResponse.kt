package com.naumov.reddit.data.response

import com.google.gson.annotations.SerializedName

class RedditResponse(
    @SerializedName("data") val listing: ListingResponse
)