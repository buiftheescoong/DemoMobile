package com.example.demobai7

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException
import org.json.JSONException
import org.json.JSONObject

@Composable
// Hàm thực hiện yêu cầu mạng sử dụng OkHttp
fun OkHttpExample() {
    var responseText by remember { mutableStateOf("Loading...") }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            responseText = fetchData("https://jsonplaceholder.typicode.com/posts/1")
        }
    }

    Text(
        text = responseText,
        modifier = Modifier.padding(top = 30.dp)
    ) // Hiển thị phản hồi
}

// Hàm thực hiện yêu cầu mạng sử dụng OkHttp
suspend fun fetchData(url: String): String {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(url)
        .build()

    return withContext(Dispatchers.IO) {
        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                // Đọc dữ liệu phản hồi
                val responseData = response.body?.string() ?: ""
                // Chuyển đổi thành JSON để lấy giá trị
                val json = JSONObject(responseData)
                json.getString("title") // Lấy giá trị của trường "title"
            }
        } catch (e: IOException) {
            "Error: ${e.message}" // Xử lý IOException
        } catch (e: JSONException) {
            "Error parsing JSON: ${e.message}" // Xử lý JSONException
        } catch (e: Exception) {
            "Unexpected error: ${e.message}" // Xử lý mọi lỗi khác
        }
    }
}