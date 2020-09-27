package com.naumov.reddit.presentation

import android.util.Log
import androidx.lifecycle.*
import com.naumov.reddit.domain.GetPostsUseCase
import com.naumov.reddit.domain.model.Listing
import com.naumov.reddit.domain.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel(), LifecycleObserver {

    private var disposable: Disposable? = null

    private val posts: MutableLiveData<List<Post>> = MutableLiveData()
    fun getPosts(): LiveData<List<Post>> = posts

    @OnLifecycleEvent(value = Lifecycle.Event.ON_CREATE)
    fun onCreated() {
        disposable = getPostsUseCase.execute(PAGE_SIZE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    onPostsLoaded(it)
                },
                {
                    Log.e(TAG, it.localizedMessage ?: it.toString())
                }
            )

    }

    private fun onPostsLoaded(listing: Listing) {
        posts.value = listing.posts
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }

    companion object {
        private const val TAG = "MainScreen"
        private const val PAGE_SIZE = 10
    }
}