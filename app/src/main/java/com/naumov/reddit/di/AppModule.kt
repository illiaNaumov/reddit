package com.naumov.reddit.di

import com.naumov.reddit.data.PostRepositoryImpl
import com.naumov.reddit.data.PostResponseMapper
import com.naumov.reddit.domain.GetPostsUseCase
import com.naumov.reddit.domain.PostRepository
import com.naumov.reddit.presentation.MainViewModel
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

    factory {
        GetPostsUseCase(
            postRepository = get()
        )
    }

    viewModel {
        MainViewModel(
            getPostsUseCase = get()
        )
    }
}