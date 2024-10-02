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
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
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

class CheckBox : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoBai4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CheckboxExample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CheckboxExample(modifier: Modifier = Modifier) {
    var checkedState1 by remember { mutableStateOf(false) }
    var checkedState2 by remember { mutableStateOf(true) }
    var checkedState3 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row() {
            Checkbox(
                checked = checkedState1,
                onCheckedChange = { checkedState1 = it }
            )
            Text("Chocolate Syrup")
        }
        Row() {
            Checkbox(
                checked = checkedState2,
                onCheckedChange = { checkedState2 = it }
            )
            Text("Sprinkles")
        }
        Row() {
            Checkbox(
                checked = checkedState3,
                onCheckedChange = { checkedState3 = it }
            )
            Text("Crushed Nuts")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val selectedOptions = mutableListOf<String>()
            if (checkedState1) selectedOptions.add("Chocolate Syrup")
            if (checkedState2) selectedOptions.add("Sprinkles")
            if (checkedState3) selectedOptions.add("Crushed Nuts")

        }) {
            Text("Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxPreview() {
    DemoBai4Theme {
        CheckboxExample()
    }
}