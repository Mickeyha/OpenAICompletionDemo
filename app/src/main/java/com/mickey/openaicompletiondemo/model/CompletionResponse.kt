package com.mickey.openaicompletiondemo.model

import kotlinx.serialization.SerialName

data class CompletionResponse(
    @SerialName(value = "id")
    val id: String?,
    @SerialName(value = "choices")
    val choices: List<CompletionChoices>,
)
