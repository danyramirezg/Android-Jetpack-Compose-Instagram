package com.example.android_jetpack_compose_instagram.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    // The getRetrofit function give back the configured Retrofit instance
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create()) // Convert the Json in data class
            .build() // Create the retrofit object
    }
}