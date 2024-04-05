package com.example.cryptotrackerapp.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotrackerapp.data.AssetsRepository
import com.example.cryptotrackerapp.model.Asset
import kotlinx.coroutines.launch

class AssetsViewModel : ViewModel() {
    private val assetsRepository = AssetsRepository()

    var assets = mutableStateListOf<Asset>()
    fun fetchAssets() {
        viewModelScope.launch {
            try {

                val response = assetsRepository.getAssets().data
                val assetsResponse = response.map { assetResponse ->
                    val price = String.format("%.2f", assetResponse.priceUsd.toDouble()).toDouble()
                    val percentage =
                        String.format("%.2f", assetResponse.changePercent24Hr.toDouble()).toDouble()
                    Asset(
                        assetResponse.id,
                        assetResponse.name,
                        assetResponse.symbol,
                        price,
                        percentage,
                    )
                }
                assets.addAll(assetsResponse)
            } catch (e: Exception) {
                Log.e("FetchAssets", e.message.toString())
            }
        }
    }
}