package com.naumov.reddit.domain.model

import java.util.*

data class Post(
    val id: String,
    val title: String,
    val author: String,
    val date: Date,
    val thumbnail: String,
    val commentCount: Int
)