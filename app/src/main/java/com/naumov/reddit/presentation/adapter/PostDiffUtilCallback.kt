package com.naumov.reddit.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.naumov.reddit.domain.model.Post

class PostDiffUtilCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}