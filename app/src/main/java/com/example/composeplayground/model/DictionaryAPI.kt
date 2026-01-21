package com.example.composeplayground.model

import retrofit2.http.GET
import retrofit2.http.Path


interface DictionaryAPI {

    @GET("api/v2/entries/en/{word}")
    suspend fun  getWordMeaning(
        @Path("word") word: String
    ): List<DictionaryData>
}