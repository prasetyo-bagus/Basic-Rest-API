package com.bytyo.harrypotter.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitPotterAPI {
    private const val BASE_URL =
        "https://potterapi-fedeperin.vercel.app/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val potterAPIService: PotterAPIService by lazy {
        retrofit.create(PotterAPIService::class.java)
    }
}
