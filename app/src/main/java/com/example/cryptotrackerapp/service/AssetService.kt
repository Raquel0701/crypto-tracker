package com.example.cryptotrackerapp.service

import com.example.cryptotrackerapp.model.AssetResponse
import com.example.cryptotrackerapp.model.AssetsResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface AssetService {
    @GET("assets")
    suspend fun getAssets():AssetsResponse



}