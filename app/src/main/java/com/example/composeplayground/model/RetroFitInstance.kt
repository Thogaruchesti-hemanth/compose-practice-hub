package com.example.composeplayground.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInstance {
    private const val BASE_URL = "https://api.dictionaryapi.dev/"

    val api: DictionaryAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryAPI::class.java)
    }
}