package com.adrianczuczka.asostask.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RecipeClient {

    private const val BASE_URL = "http://mobile.asosservices.com/sampleapifortest/"

    //Needs to be initialized outside of the object because it requires context
    lateinit var client: OkHttpClient

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private val api: RecipeAPI by lazy {
        retrofit.create(RecipeAPI::class.java)
    }

    val repository: RecipeRepository by lazy {
        RecipeRepository(api)
    }

    fun hasNetwork(context: Context): Boolean {
        var isConnected = false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}