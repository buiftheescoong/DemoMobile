package com.example.demobai7

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.nio.charset.StandardCharsets

// Hàm để chuyển đổi InputStream thành String
private fun convertInputStreamToString(inputStream: InputStream): String? {
//    return InputStreamReader(inputStream, StandardCharsets.UTF_8).use { reader ->
//        reader.readText() // Đọc toàn bộ nội dung stream thành chuỗi
//    }

    val builder = StringBuilder()
    val reader = BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))

    // Đọc từng dòng từ InputStream và thêm vào StringBuilder
    reader.use {
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            builder.append(line).append("\n") // Thêm dòng vào builder
        }
    }

    // Kiểm tra xem builder có rỗng không
    return if (builder.isEmpty()) {
        null // Trả về null nếu không có dữ liệu
    } else {
        builder.toString() // Trả về chuỗi kết quả
    }
}


// Hàm để lấy nội dung từ URL
suspend fun fetchContentFromUrl(requestURL: URL): String? {
    return withContext(Dispatchers.IO) {
        var connection: HttpURLConnection? = null
        var inputStream: InputStream? = null
        return@withContext try {
            connection = requestURL.openConnection() as HttpURLConnection
            connection.apply {
                readTimeout = 10000 // milliseconds
                connectTimeout = 15000 // milliseconds
                requestMethod = "GET"
                doInput = true // Cho phép input stream
            }

            connection.connect() // Kết nối tới URL
            val responseCode = connection.responseCode // Lấy mã phản hồi

            if (responseCode == HttpURLConnection.HTTP_OK) { // Kiểm tra mã phản hồi
                inputStream = connection.inputStream // Lấy input stream
                convertInputStreamToString(inputStream) // Đọc input stream thành chuỗi
            } else {
                null // Xử lý mã phản hồi khác
            }
        } catch (e: Exception) {
            e.printStackTrace() // Xử lý ngoại lệ nếu cần
            null // Trả về null nếu có lỗi
        } finally {
            connection?.disconnect() // Ngắt kết nối
            inputStream?.close() // Đóng input stream
        }
    }
}
@Composable
fun HttpURLConnectionExample() {
    val requestURL = URL("https://jsonplaceholder.typicode.com/posts/1") // Thay thế bằng URL thực tế

    var content by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        content = fetchContentFromUrl(requestURL)
    }

    if (content != null) {
        Text(
            text = content ?: "No content found",
            modifier = Modifier.padding(top = 30.dp)
        )
    } else {
        Text(text = "Loading...")
    }
}