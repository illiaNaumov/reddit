package com.naumov.reddit.presentation.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.naumov.reddit.R
import com.naumov.reddit.domain.model.Post
import com.naumov.reddit.presentation.util.toggleVisibility
import com.squareup.picasso.Picasso

class PostAdapter(
    private val onClick: (Post) -> Unit
) : PagingDataAdapter<Post, PostAdapter.PostViewHolder>(PostDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vertical_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = getItem(position) ?: return
        return holder.bind(item, onClick)
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val info: TextView = view.findViewById(R.id.infoView)
        private val title: TextView = view.findViewById(R.id.titleView)
        private val thumbnail: ImageView = view.findViewById(R.id.thumbnailView)
        private val commentCount: TextView = view.findViewById(R.id.commentsCountView)

        fun bind(post: Post, onClick: (Post) -> Unit) {
            info.text = post.author
            title.text = post.title
            commentCount.text = post.commentCount.toString()

            val preview = post.preview?.url
            thumbnail.toggleVisibility(preview != null)

            preview?.let {
                thumbnail.setOnClickListener { onClick(post) }
                Picasso.get()
                    .load(it)
                    .placeholder(R.drawable.ic_placeholder)
                    .into(thumbnail)
            }
        }
    }
}
