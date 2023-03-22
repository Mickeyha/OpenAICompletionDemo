package com.mickey.openaicompletiondemo.network

import com.mickey.openaicompletiondemo.model.CompletionRequest
import com.mickey.openaicompletiondemo.model.CompletionResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * A public interface that exposes the [getOpenAICompletion] method
 */
interface OpenAIApiService {
    /**
     * Returns a [CompletionResponse] and this method can be called from a Coroutine.
     * The @POST annotation indicates that the "completions" endpoint will be requested with the POST
     * HTTP method
     */
    @POST("v1/chat/completions")
    suspend fun getOpenAICompletion(
        @Body completionRequest: CompletionRequest
    ): CompletionResponse
}