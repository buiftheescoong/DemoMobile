package com.example.demobai4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
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

class RadioGroup : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoBai4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RadioGroupExample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RadioGroupExample(modifier: Modifier = Modifier) {
    var selectedOption by remember { mutableStateOf("Same day messenger service") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Choose a delivery method:")
        Spacer(modifier = Modifier.height(8.dp))


        RadioButton(
            selected = selectedOption == "Same day messenger service",
            onClick = {
                selectedOption = "Same day messenger service"
            }
        )
        Text("Same day messenger service")

        RadioButton(
            selected = selectedOption == "Next day ground delivery",
            onClick = {
                selectedOption = "Next day ground delivery"
            }
        )
        Text("Next day ground delivery")

        RadioButton(
            selected = selectedOption == "Pick up",
            onClick = {
                selectedOption = "Pick up"
            }
        )
        Text("Pick up")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

            }
        ) {
            Text("Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RadioButtonPreview() {
    DemoBai4Theme {
        RadioGroupExample()
    }
}