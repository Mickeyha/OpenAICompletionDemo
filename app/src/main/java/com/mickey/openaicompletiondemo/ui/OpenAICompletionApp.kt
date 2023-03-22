package com.mickey.openaicompletiondemo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mickey.openaicompletiondemo.ui.screens.CompletionViewModel
import com.mickey.openaicompletiondemo.ui.screens.HomeScreen
import com.mickey.openaicompletiondemo.R

@Composable
fun OpenAICompletionApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            val completionViewModel: CompletionViewModel =
                viewModel(factory = CompletionViewModel.Factory)
            HomeScreen(
                completionsUiState = completionViewModel.completionUiState
            )
        }
    }
}