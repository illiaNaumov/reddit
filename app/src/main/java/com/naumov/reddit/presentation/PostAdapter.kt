package com.naumov.reddit.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.naumov.reddit.R
import com.naumov.reddit.domain.model.Post
import com.squareup.picasso.Picasso

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    val posts: MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        return holder.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val info: TextView = view.findViewById(R.id.infoView)
        private val title: TextView = view.findViewById(R.id.titleView)
        private val thumbnail: ImageView = view.findViewById(R.id.thumbnailView)
        private val commentCount: TextView = view.findViewById(R.id.commentsCountView)


        fun bind(post: Post) {
            info.text = post.author
            title.text = post.title
            commentCount.text = post.commentCount.toString()

            Picasso.get()
                .load(post.thumbnail)
                .into(thumbnail)
        }
    }
}