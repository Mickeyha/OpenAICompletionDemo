package com.mickey.openaicompletiondemo.model

import kotlinx.serialization.SerialName

data class CompletionMessage(
    @SerialName(value = "role")
    val role: String = "user",
    @SerialName(value = "content")
    val content: String?
)
