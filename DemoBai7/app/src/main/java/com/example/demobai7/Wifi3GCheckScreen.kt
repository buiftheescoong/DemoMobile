package com.example.demobai7

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

fun isWifiAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
}
fun isMobileDataAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
}

@Composable
fun Wifi3GCheckScreen(stringUrl: String) {
    val context = LocalContext.current
    var isWifiConnected by remember { mutableStateOf(false) }
    var isMobileDataConnected by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isWifiConnected = isWifiAvailable(context)
        isMobileDataConnected = isMobileDataAvailable(context)
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 30.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = if (isWifiConnected) "Wi-Fi is connected" else "Wi-Fi is not connected")
        Text(text = if (isMobileDataConnected) "Mobile Data is connected" else "Mobile Data is not connected")
    }
}
