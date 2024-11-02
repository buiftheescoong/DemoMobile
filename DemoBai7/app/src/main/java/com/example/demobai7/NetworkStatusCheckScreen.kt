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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
    return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}

suspend fun downloadWebpage(stringUrl: String) {
    //
}

@Composable
fun NetworkStatusCheckScreen(stringUrl: String) {
    val context = LocalContext.current
    var networkStatus by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        networkStatus = isNetworkAvailable(context)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        if (networkStatus) {
            Text(text = "Network connected!")
            Button(onClick = {
                coroutineScope.launch(Dispatchers.IO) {
                    downloadWebpage(stringUrl)
                }
            }) {
                Text(text = "Download Data")
            }
        } else {
            Text(text = "No network connection available.")
        }
    }
}

