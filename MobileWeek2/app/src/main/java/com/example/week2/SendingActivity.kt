package com.example.week2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.week2.ui.theme.Week2Theme

class SendingActivity : ComponentActivity() {

    companion object {
        const val EXTRA_MESSAGE_KEY = "com.example.android.twoactivities.extra.MESSAGE"
        const val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
    }

    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week2Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SendDataButton()
                }
            }
        }

        startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val reply = result.data?.getStringExtra(EXTRA_REPLY)
                reply?.let {
                    Toast.makeText(this, "Received reply: $it", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    @Composable
    fun SendDataButton(modifier: Modifier = Modifier) {
        Button(
            onClick = {
                val intent = Intent(this, ReceivingActivity::class.java)
                val message = "Hello Activity!"
                intent.putExtra(EXTRA_MESSAGE_KEY, message)
                startForResult.launch(intent)
            },
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Send Data")
        }
    }
}
