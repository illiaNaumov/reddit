package com.naumov.reddit.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.naumov.reddit.data.RedditPagingSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class MainViewModel(
    private val redditPagingSource: RedditPagingSource
) : ViewModel() {

    private var viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val flow = Pager(PagingConfig(PAGE_SIZE)) { redditPagingSource }
        .flow
        .cachedIn(viewModelScope)

    companion object {
        private const val TAG = "MainScreen"
        private const val PAGE_SIZE = 10
    }
}