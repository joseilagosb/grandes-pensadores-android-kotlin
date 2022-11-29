package com.example.grandespensadores.api

import retrofit2.Call
import retrofit2.http.GET

interface KanyeWestAPIService {
    @GET(".")
    fun getQuote(): Call<KanyeWestAPIResult>
}