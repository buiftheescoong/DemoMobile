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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demobai4.ui.theme.DemoBai4Theme

class ViewMethod : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoBai4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RequestFocusExample(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RequestFocusExample(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }

    Column {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("TextField") },
            modifier = Modifier.focusRequester(focusRequester)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            focusRequester.requestFocus()
        }) { // Yêu cầu focus
            Text("Focus vào TextField")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ViewMethodPreview() {
    DemoBai4Theme {
        RequestFocusExample()
    }
}