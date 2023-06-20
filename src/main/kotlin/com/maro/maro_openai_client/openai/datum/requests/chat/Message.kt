package com.maro.maro_openai_client.openai.datum.requests.chat

data class Message(
    val role: String,
    val content: String
)