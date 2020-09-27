package com.naumov.reddit.di

import com.naumov.reddit.data.RedditApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory {
        HttpLoggingInterceptor()
            .apply { setLevel(HttpLoggingInterceptor.Level.BODY) }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RedditApi::class.java)

    } bind RedditApi::class
}

private const val BASE_URL = "https://www.reddit.com/"