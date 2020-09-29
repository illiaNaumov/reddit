package com.naumov.reddit.domain.model

import java.util.*

data class Post(
    val id: String,
    val title: String,
    val author: String,
    val date: Date,
    val url: String,
    val commentCount: Int,
    val thumbnail: String,
    val preview: Preview?,
)