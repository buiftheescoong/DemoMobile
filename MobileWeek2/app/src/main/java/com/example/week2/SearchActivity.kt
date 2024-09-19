package com.example.week2

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SearchActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WebSearchApp()
        }
    }

    @Composable
    fun WebSearchApp() {
        var context = LocalContext.current
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = {
                val url = "https://www.google.com/search?q=UET"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)

                if (intent.resolveActivity(packageManager) != null) {
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "No application found to open web browser", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text("Search Web")
            }
        }
    }
}
