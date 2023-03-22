package com.mickey.openaicompletiondemo.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mickey.openaicompletiondemo.OpenAICompletionApplication
import com.mickey.openaicompletiondemo.data.OpenAIRepository
import com.mickey.openaicompletiondemo.model.CompletionMessage
import com.mickey.openaicompletiondemo.model.CompletionRequest
import com.mickey.openaicompletiondemo.model.CompletionResponse
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface CompletionUiState {
    data class Success(val response: CompletionResponse) : CompletionUiState
    object Loading : CompletionUiState
    object Error : CompletionUiState
}

class CompletionViewModel(private val openAIRepository: OpenAIRepository) : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var completionUiState: CompletionUiState by mutableStateOf(CompletionUiState.Loading)
        private set
    /**
     * Call getOpenAICompletions() on init so we can display status immediately.
     */
    init {
        getOpenAICompletions()
    }

    /**
     * Gets OpenAI completions from the OpenAI API Retrofit service.
     */
    fun getOpenAICompletions() {
        viewModelScope.launch {
            completionUiState = CompletionUiState.Loading
            completionUiState = try {
                val messages = mutableListOf<CompletionMessage>()
                messages.add(CompletionMessage(content = "Hello!"))
//                val response = openAIRepository.getOpenAICompletion(
//                    CompletionRequest(messages = messages)
//                )
//                Log.d("Mickey"," response = $response")
                CompletionUiState.Success(openAIRepository.getOpenAICompletion(
                    CompletionRequest(messages = messages)
                ))
            } catch (e: IOException) {
                CompletionUiState.Error
            } catch (e: HttpException) {
                CompletionUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as OpenAICompletionApplication)
                val openAIRepository = application.container.openAIRepository
                CompletionViewModel(openAIRepository = openAIRepository)
            }
        }
    }
}