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
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

@Composable
fun JSONObjectExample() {
    val context = LocalContext.current
    var countryInfo by remember { mutableStateOf("Loading...") }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            countryInfo = loadCountryJson(context)
        }
    }

    Column {
        Text(
            text = countryInfo,
            modifier = Modifier.padding(top = 30.dp)
        )
    }
}

suspend fun loadCountryJson(context: Context): String {
    return withContext(Dispatchers.IO) {
        try {
            // Đọc tệp country_population.json từ thư mục assets
            val jsonString = context.assets.open("city.json").bufferedReader().use { it.readText() }

            // Phân tích tệp JSON
            val jsonObject = JSONObject(jsonString)
            val nameOfCountry = jsonObject.getString("country")
            val population = jsonObject.getLong("population")
            val listOfCities = jsonObject.getJSONArray("cities")

            // Xây dựng chuỗi thông tin để hiển thị
            val cities = StringBuilder()
            for (i in 0 until listOfCities.length()) {
                cities.append(listOfCities.getString(i))
                if (i < listOfCities.length() - 1) cities.append(", ") // Thêm dấu phẩy giữa các thành phố
            }

            "Country: $nameOfCountry\nPopulation: $population\nCities: $cities"
        } catch (e: IOException) {
            "Error loading: ${e.message}"
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}