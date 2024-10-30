package com.example.demo74

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.demo74.ui.theme.Demo74Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Demo74Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ServiceControlScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ServiceControlScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column {
        Button(onClick = {
            // Bắt đầu HelloIntentService
//            val startIntent = Intent(context, HelloIntentService::class.java)
            val startIntent = Intent(context, HelloCoroutineService::class.java)
            context.startService(startIntent)
        }) {
            Text("Start Service")
        }
    }
}