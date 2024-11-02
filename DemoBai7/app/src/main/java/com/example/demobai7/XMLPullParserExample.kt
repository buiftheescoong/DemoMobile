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
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory

@Composable
fun XMLPullParserExample() {
    var responseText by remember { mutableStateOf("Loading...") }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            responseText = fetchXmlData("https://www.w3schools.com/xml/note.xml")
        }
    }

    Text(
        text = responseText,
        modifier = Modifier.padding(top = 30.dp)
    ) // Hiển thị phản hồi
}

// Hàm thực hiện yêu cầu mạng và phân tích cú pháp XML
suspend fun fetchXmlData(url: String): String {
    val client = OkHttpClient()
    val request = Request.Builder().url(url).build()
    return withContext(Dispatchers.IO) {
        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                // Đọc dữ liệu phản hồi
                val responseData = response.body?.string() ?: ""

                // Phân tích cú pháp XML
                val parser = XmlPullParserFactory.newInstance().newPullParser()
                parser.setInput(responseData.reader())
                var eventType = parser.eventType
                val result = StringBuilder()

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG && parser.name == "body") {
                        result.append(parser.nextText()).append("\n")
                    }
                    eventType = parser.next()
                }
                result.toString()
            }
        } catch (e: IOException) {
            "Error: ${e.message}" // Xử lý IOException
        } catch (e: Exception) {
            "Unexpected error: ${e.message}" // Xử lý mọi lỗi khác
        }
    }
}
