package com.adrianczuczka.asostask

import android.app.Application
import com.adrianczuczka.asostask.network.RecipeClient
import okhttp3.Cache
import okhttp3.OkHttpClient

class ASOSApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(this.cacheDir, cacheSize)

        RecipeClient.client = OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (RecipeClient.hasNetwork(this)) {
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                } else {
                    request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                }
                chain.proceed(request)
            }
            .build()
    }
}