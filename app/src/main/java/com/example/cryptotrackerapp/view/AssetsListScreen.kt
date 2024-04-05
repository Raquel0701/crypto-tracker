package com.example.cryptotrackerapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cryptotrackerapp.model.Asset
import com.example.cryptotrackerapp.viewmodel.AssetsViewModel

@Composable

fun AssetList(viewModel: AssetsViewModel) {
    val assets = viewModel.assets
    LaunchedEffect(Unit) {
        viewModel.fetchAssets()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBackground)
    ) {
        items(assets) { currentAsset ->
            AssetRow(asset = currentAsset)
        }
    }
}

@Composable

fun AssetRow(asset: Asset) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(15.dp)
        ) {
            if (LocalInspectionMode.current) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null,
                    tint = Color.LightGray,
                    modifier = Modifier
                        .size(50.dp)
                )
            } else {
                AsyncImage(
                    model = "https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png",
                    contentDescription = null,
                )
            }
        }



        Column {
            Text(text = asset.name, fontSize = 16.sp)
            Text(text = asset.symbol, fontSize = 12.sp)

        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "${asset.price}",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
        Text(
            text = "${asset.percentage}",
            fontSize = 16.sp,
            color = if (asset.percentage >= 0) Color.Green else Color.Red,
            modifier = Modifier
                .padding(horizontal = 8.dp)

        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable

fun AssetRowPreview() {
    AssetList(AssetsViewModel())
}
