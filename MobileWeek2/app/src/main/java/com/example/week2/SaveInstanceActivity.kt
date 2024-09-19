package com.example.week2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SaveInstanceActivity : ComponentActivity() {

    companion object {
        const val COUNT_KEY = "count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val initialCount = savedInstanceState?.getInt(COUNT_KEY) ?: 0
        setContent {
            CounterApp(initialCount)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_KEY, CounterApp.currentCount)
    }
}

@Composable
fun CounterApp(initialCount: Int) {
    var count by remember { mutableStateOf(initialCount) }
    CounterApp.currentCount = count
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "$count",
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { count++ }) {
            Text("Increase Count")
        }
    }
}

object CounterApp {
    var currentCount: Int = 0
}
