package com.mickey.openaicompletiondemo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text
import com.mickey.openaicompletiondemo.model.CompletionResponse

@Composable
fun HomeScreen(
    completionsUiState: CompletionUiState,
    modifier: Modifier = Modifier
) {
    when (completionsUiState) {
        is CompletionUiState.Loading -> LoadingScreen(modifier)
        is CompletionUiState.Success -> CompletionsScreen(completionsUiState.response, modifier)
        is CompletionUiState.Error -> ErrorScreen(modifier)
    }
}

/**
 * The home screen displaying the loading message.
 */
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.size(200.dp),
            text = "Loading..."
        )
    }
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Failed to load")
        // TODO may add retry button here
    }
}

/**
 * The home screen displaying completions view.
 */
@Composable
fun CompletionsScreen(completions: CompletionResponse, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TODO add null check
        val choices = completions.choices.first().message.content
        Text(text = "$choices")
        // TODO may add retry button here
    }
}
