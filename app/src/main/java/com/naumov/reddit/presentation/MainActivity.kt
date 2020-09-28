package com.naumov.reddit.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.naumov.reddit.R
import com.naumov.reddit.presentation.adapter.PostAdapter
import com.naumov.reddit.presentation.adapter.PostLoadStateAdapter
import com.naumov.reddit.presentation.util.toggleVisibility
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val postsAdapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        postsView.adapter = postsAdapter.withLoadStateFooter(
            PostLoadStateAdapter {
                postsAdapter.retry()
            })

        swipeRefreshView.setOnRefreshListener {
            postsAdapter.refresh()
        }

        retryView.setOnClickListener {
            postsAdapter.refresh()
        }

        lifecycleScope.launch {
            viewModel.flow.collectLatest { pagingData ->
                postsAdapter.submitData(pagingData)
            }
        }

        lifecycleScope.launch {
            postsAdapter.loadStateFlow.collectLatest { loadState ->
                swipeRefreshView.isRefreshing = loadState.refresh is LoadState.Loading
                retryView.toggleVisibility(loadState.refresh is LoadState.Error)
            }
        }
    }
}