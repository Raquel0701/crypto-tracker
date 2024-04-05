package com.example.cryptotrackerapp.model

data class AssetResponse (
    val id:String,
    var name: String,
    val symbol: String,
    var priceUsd: String,
    var changePercent24Hr: String

)


