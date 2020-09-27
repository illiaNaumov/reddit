package com.naumov.reddit.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.naumov.reddit.R
import com.naumov.reddit.domain.model.Post
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lifecycle.addObserver(viewModel)
        initLiveData()
    }

    private fun initLiveData() {
        viewModel.getPosts().observe(this, ::handlePosts)
    }

    private fun handlePosts(posts: List<Post>?) {
        Log.d("TEST", posts.toString())
    }
}