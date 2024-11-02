package com.example.usernavigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class DrawerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerDemo()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerDemo() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(onCloseDrawer = { scope.launch { drawerState.close() } })
        }
    ) {
        // Nội dung chính
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Navigation Drawer Demo") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                )
            }
        ) { innerPadding ->
            // Nội dung chính
            Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                Text("Content here", modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerContent(onCloseDrawer: () -> Unit) {
    val context = LocalContext.current
    // Nội dung của Drawer
    Column {
        Button(
            onClick = {
                val intent = Intent(context, ChildActivity::class.java)
                context.startActivity(intent)
            },
            Modifier.padding(top = 48.dp)
        ) {
            Text("Mục 1", modifier = Modifier
                , color = Color.Black)
        }
        Button(
            onClick = {
                val intent = Intent(context, ChildActivity::class.java)
                context.startActivity(intent)
            },
            Modifier.padding(top = 48.dp)
        ) {
            Text("Mục 2", modifier = Modifier
                , color = Color.Black)
        }
        HorizontalDivider()
        Button(
            onClick = {
                val intent = Intent(context, ChildActivity::class.java)
                context.startActivity(intent)
            },
            Modifier.padding(top = 48.dp)
        ) {
            Text("Mục 3", modifier = Modifier
                , color = Color.Black)
        }
    }
}
