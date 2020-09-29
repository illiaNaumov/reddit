package com.naumov.reddit.di

import com.naumov.reddit.data.PostRepositoryImpl
import com.naumov.reddit.data.PostResponseMapper
import com.naumov.reddit.domain.PostRepository
import com.naumov.reddit.presentation.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    single {
        PostRepositoryImpl(
            redditApi = get(),
            postResponseMapper = PostResponseMapper()
        )
    } bind PostRepository::class

    viewModel {
        MainViewModel(
            postRepository = get()
        )
    }
}