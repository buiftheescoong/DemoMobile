package com.example.demobai4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import com.example.demobai4.ui.theme.DemoBai4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoBai4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NextFocus(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}



@Composable
fun NextFocus(modifier: Modifier = Modifier) {
    val focusManager = LocalFocusManager.current
    Column {
        Button(
            onClick = {

            },
            modifier = Modifier
                .focusable(true)
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                }
        ) {
            Text(text = "Button 1")
        }

        Button(
            onClick = {

            },
            modifier = Modifier.focusable(true)
        ) {
            Text(text = "Button 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    DemoBai4Theme {
        NextFocus()
    }
}