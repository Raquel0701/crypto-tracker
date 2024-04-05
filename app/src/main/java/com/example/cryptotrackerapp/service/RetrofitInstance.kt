package com.example.cryptotrackerapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val BASE_URL = "https://909b4d9a-4ecf-4207-b19b-27c15dea1dd2.mock.pstmn.io/v2/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val assetsService: AssetService by lazy{
        retrofit.create(AssetService::class.java)
    }


}