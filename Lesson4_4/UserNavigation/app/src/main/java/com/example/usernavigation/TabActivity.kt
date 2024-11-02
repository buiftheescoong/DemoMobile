package com.example.usernavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.usernavigation.ui.theme.UserNavigationTheme

class TabActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserNavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TabDemo()
                }
            }
        }
    }
}

@Composable
fun TabDemo(modifier: Modifier = Modifier) {
    // Trạng thái cho tab đã chọn
    var selectedTab by remember { mutableStateOf(0) }

    // Các tiêu đề cho tab
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

    // Giao diện chính với TabRow
    Column(
        modifier = Modifier.padding(top = 40.dp)
    ) {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        // Hiển thị nội dung tương ứng với tab đã chọn
        when (selectedTab) {
            0 -> TabContent("Content 1")
            1 -> TabContent("Content 2")
            2 -> TabContent("Content 3")
        }
    }
}

@Composable
fun TabContent(content: String) {
    // Hiển thị nội dung cho tab đã chọn
    Text(
        text = content,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()

    )
}
