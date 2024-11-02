package com.example.demobai7

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.IOException

@Composable
fun JSONObjectExample2() {
    val context = LocalContext.current
    var menuItemOnClick by remember { mutableStateOf("Loading...") }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            menuItemOnClick = loadMenuJson(context)
        }
    }

    Column {
        Text(
            text = menuItemOnClick,
            modifier = Modifier.padding(top = 30.dp)
        )
    }
}

suspend fun loadMenuJson(context: Context): String {
    return withContext(Dispatchers.IO) {
        try {
            // Đọc tệp menu.json từ thư mục assets
            val jsonString = context.assets.open("menu.json").bufferedReader().use { it.readText() }

            // Phân tích tệp JSON và lấy giá trị "onclick" của mục thứ 3
            val jsonObject = JSONObject(jsonString)
            val menuItemArray = jsonObject.getJSONObject("menu")
                .getJSONObject("popup")
                .getJSONArray("menuitem")

            val thirdItem = menuItemArray.getJSONObject(2)
            thirdItem.getString("onclick") // Trả về giá trị của "onclick"
        } catch (e: IOException) {
            "Error loading: ${e.message}"
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}