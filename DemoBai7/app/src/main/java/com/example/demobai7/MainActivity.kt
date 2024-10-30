package com.example.demobai7

import HttpURLConnectionExample
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.demobai7.ui.theme.DemoBai7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoBai7Theme {
//             NetworkStatusCheckScreen(stringUrl = "https://example.com")
//                UrlBuilder()
//              HttpURLConnectionExample()
                OkHttpExample()
//               XMLPullParserExample()
//                JSONObjectExample()
//             JSONObjectExample2()
            }
        }
    }
}
