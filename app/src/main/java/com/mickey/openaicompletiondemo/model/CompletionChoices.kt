package com.mickey.openaicompletiondemo.model

import kotlinx.serialization.SerialName

data class CompletionChoices(
    @SerialName(value = "index")
    val index: Int,
    @SerialName(value = "message")
    val message: CompletionMessage,
    @SerialName(value = "finish_reason")
    val finish_reason: String?,
)