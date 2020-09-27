package com.naumov.reddit.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.naumov.reddit.R
import com.naumov.reddit.domain.model.Post
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val postsAdapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.lifecycle.addObserver(viewModel)

        initView()
        initLiveData()
    }

    private fun initView() {
        postsView.adapter = postsAdapter
    }

    private fun initLiveData() {
        viewModel.getPosts().observe(this, ::handlePosts)
    }

    private fun handlePosts(posts: List<Post>) {
        postsAdapter.posts.clear()
        postsAdapter.posts.addAll(posts)
        postsAdapter.notifyDataSetChanged()
    }
}