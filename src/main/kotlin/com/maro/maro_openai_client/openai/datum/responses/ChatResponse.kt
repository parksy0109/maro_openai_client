package com.maro.maro_openai_client.openai.datum.responses


import com.fasterxml.jackson.annotation.JsonProperty

data class ChatResponse(
    @JsonProperty("choices")
    val choices: List<Choice?>?,
    @JsonProperty("created")
    val created: Int?,
    @JsonProperty("id")
    val id: String?,
    @JsonProperty("model")
    val model: String?,
    @JsonProperty("object")
    val objectX: String?,
    @JsonProperty("usage")
    val usage: Usage?
) {
    data class Choice(
        @JsonProperty("finish_reason")
        val finishReason: String?,
        @JsonProperty("index")
        val index: Int?,
        @JsonProperty("message")
        val message: Message?
    ) {
        data class Message(
            @JsonProperty("content")
            val content: String?,
            @JsonProperty("role")
            val role: String?
        )
    }

    data class Usage(
        @JsonProperty("completion_tokens")
        val completionTokens: Int?,
        @JsonProperty("prompt_tokens")
        val promptTokens: Int?,
        @JsonProperty("total_tokens")
        val totalTokens: Int?
    )
}