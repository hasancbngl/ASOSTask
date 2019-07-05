package com.adrianczuczka.asostask.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RecipeClient {

    private const val BASE_URL = "http://mobile.asosservices.com/sampleapifortest/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    val api: RecipeAPI by lazy {
        retrofit.create(RecipeAPI::class.java)
    }

    val repository: RecipeRepository by lazy {
        RecipeRepository(api)
    }
}