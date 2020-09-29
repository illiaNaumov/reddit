package com.naumov.reddit.presentation.main

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.naumov.reddit.data.RedditPagingSource
import com.naumov.reddit.domain.PostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class MainViewModel(
    private val postRepository: PostRepository
) : ViewModel() {

    private var viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val flow = Pager(PagingConfig(PAGE_SIZE)) { RedditPagingSource(postRepository) }
        .flow
        .cachedIn(viewModelScope)

    companion object {
        private const val TAG = "MainScreen"
        private const val PAGE_SIZE = 10
    }
}