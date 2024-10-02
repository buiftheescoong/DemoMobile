package com.example.demobai4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demobai4.ui.theme.DemoBai4Theme

class ToggleAndSwitch : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoBai4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ToggleAndSwitchExample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ToggleAndSwitchExample(modifier: Modifier = Modifier) {
    var toggleChecked by remember { mutableStateOf(false) }
    var switchChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        // ToggleButton (sử dụng Checkbox)
        Row() {
            Text("Turn on or off:")
            Checkbox(
                checked = toggleChecked,
                onCheckedChange = { toggleChecked = it },
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Switch
        Row() {
            Text("Turn on or off:")
            Switch(
                checked = switchChecked,
                onCheckedChange = { switchChecked = it }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToggleAndSwitchPreview() {
    DemoBai4Theme {
        ToggleAndSwitchExample()
    }
}