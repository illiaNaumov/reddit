package com.naumov.reddit.domain.model

class Listing(
    val posts: List<Post>,
    val after: String?
)