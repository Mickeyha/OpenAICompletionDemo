package com.mickey.openaicompletiondemo.data

import com.mickey.openaicompletiondemo.model.CompletionRequest
import com.mickey.openaicompletiondemo.model.CompletionResponse
import com.mickey.openaicompletiondemo.network.OpenAIApiService

/**
 * Repository that fetch openAI completions from OpenAIApi.
 */
interface OpenAIRepository {
    /** Fetches list of completions from OpenAIApi */
    suspend fun getOpenAICompletion(request: CompletionRequest): CompletionResponse
}

/**
 * Network Implementation of Repository that fetch openAI completions from OpenAIApi.
 */
class NetworkOpenAIRepository(
    private val openAIApiService: OpenAIApiService
) : OpenAIRepository {
    /** Fetches list of completions from OpenAIApi */
    override suspend fun getOpenAICompletion(request: CompletionRequest) =
        openAIApiService.getOpenAICompletion(request)
}