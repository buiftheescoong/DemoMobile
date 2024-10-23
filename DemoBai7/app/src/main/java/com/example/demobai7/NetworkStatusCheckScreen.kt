package com.example.demobai7

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Function to check network status
fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
//    return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
//    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
}
fun isNetworkAvailable1(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
//    return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
//    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
}

// Download task (Simulated for Compose)
suspend fun downloadWebpage(stringUrl: String) {
    // Simulating a download task, replace with actual network operation
}

// Compose UI
@Composable
fun NetworkStatusCheckScreen(stringUrl: String) {
    val context = LocalContext.current
//    var networkStatus by remember { mutableStateOf(false) }
    var isWifiConnected by remember { mutableStateOf(false) }
    var isMobileDataConnected by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    // Check network status whenever the screen is recomposed
    LaunchedEffect(Unit) {
//        networkStatus = isNetworkAvailable(context)
        isWifiConnected = isNetworkAvailable(context)
        isMobileDataConnected = isNetworkAvailable1(context)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = if (isWifiConnected) "Wi-Fi is connected" else "Wi-Fi is not connected")
        Text(text = if (isMobileDataConnected) "Mobile Data is connected" else "Mobile Data is not connected")
//        if (networkStatus) {
//            Text(text = "Network connected!")
//            Button(onClick = {
//                coroutineScope.launch(Dispatchers.IO) {
//                    downloadWebpage(stringUrl)
//                }
//            }) {
//                Text(text = "Download Data")
//            }
//        } else {
//            Text(text = "No network connection available.")
//        }
    }
}

