package com.example.grandespensadores.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object KanyeWestAPIClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.kanye.rest/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(KanyeWestAPIService::class.java)
}