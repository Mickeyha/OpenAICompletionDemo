package com.mickey.openaicompletiondemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mickey.openaicompletiondemo.ui.OpenAICompletionApp
import com.mickey.openaicompletiondemo.ui.theme.OpenAICompletionDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenAICompletionDemoTheme {
                OpenAICompletionApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OpenAICompletionDemoTheme {
        Greeting("Android")
    }
}