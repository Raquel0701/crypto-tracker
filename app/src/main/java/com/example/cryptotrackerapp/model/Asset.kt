package com.example.cryptotrackerapp.model

data class Asset(
    val id:String,
    var name: String,
    val symbol: String,
    var price: Double,
    var percentage: Double,
    ) {

}