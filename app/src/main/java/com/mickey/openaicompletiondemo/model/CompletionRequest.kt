package com.mickey.openaicompletiondemo.model

import kotlinx.serialization.SerialName

data class CompletionRequest(
    @SerialName(value = "model")
    val model: String = "gpt-3.5-turbo",
    @SerialName(value = "message")
    val messages: List<CompletionMessage>
)
