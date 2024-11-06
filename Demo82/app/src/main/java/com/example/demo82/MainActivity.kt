package com.example.demo82

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.demo82.ui.theme.Demo82Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Demo82Theme {
                AlarmManagerDemo()
//                AlarmManagerDemo2()
//                SetAlarmClockDemo()
            }
        }
    }
}
