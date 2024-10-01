package com.example.test2

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.test2.ui.theme.Test2Theme

class MainActivity : ComponentActivity() {
    var recyclerview: RecyclerView = TODO()
    var list: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        recyclerview = findViewById(R.id.recyclerView)
        recyclerview.layoutManager
        list = mutableListOf();
        list.add("Item01")
        list.add("Item02")
        list.add("Item03")
        list.add("Item04")
        list.add("Item05")

        var adapter: WordListAdapter


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Test2Theme {
        Greeting("Android")
    }
}