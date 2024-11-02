package com.example.demobai7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.demobai7.ui.theme.DemoBai7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoBai7Theme {
             NetworkStatusCheckScreen(stringUrl = "https://example.com")
//                Wifi3GCheckScreen(stringUrl = "https://example.com")
//                UrlBuilder()
//              HttpURLConnectionExample()
//                OkHttpExample()
//               XMLPullParserExample()
//                JSONObjectExample()
//             JSONObjectExample2()
            }
        }
    }
}
