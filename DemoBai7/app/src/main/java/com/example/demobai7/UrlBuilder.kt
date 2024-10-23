package com.example.demobai7

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.net.URL

fun buildRequestURL(baseUrl: String, queryParam: String, maxResults: String, printType: String): URL {
    val builtURI = Uri.parse(baseUrl).buildUpon()
        .appendQueryParameter("q", queryParam) // Thay QUERY_PARAM bằng "q"
        .appendQueryParameter("maxResults", maxResults) // Thay MAX_RESULTS bằng "maxResults"
        .appendQueryParameter("printType", printType) // Thay PRINT_TYPE bằng "printType"
        .build()

    return URL(builtURI.toString())
}

@Composable
fun UrlBuilder() {
    val baseUrl = "https://www.googleapis.com/books/v1/volumes"
    val queryParam = "pride+prejudice"
    val maxResults = "10"
    val printType = "books"

    // Xây dựng URL khi cần
    val requestURL = buildRequestURL(baseUrl, queryParam, maxResults, printType)
    // Hiển thị URL trong UI hoặc thực hiện yêu cầu mạng...
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 30.dp)
    ) {
        Text(text = "Request URL: $requestURL")
    }
}

