package com.example.week2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.week2.ui.theme.Week2Theme

class ReceivingActivity : ComponentActivity() {

    companion object {
        const val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week2Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ReturnDataButton()
                }
            }
        }
    }

    @Composable
    fun ReturnDataButton(modifier: Modifier = Modifier) {
        Button(
            onClick = {
                val replyIntent = Intent().apply {
                    putExtra(EXTRA_REPLY, "Hello from ReceivingActivity!")
                }
                setResult(Activity.RESULT_OK, replyIntent)
                finish()
            },
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Return Data")
        }
    }
}
