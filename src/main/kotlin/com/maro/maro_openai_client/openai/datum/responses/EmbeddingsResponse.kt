package com.maro.maro_openai_client.openai.datum.responses


import com.fasterxml.jackson.annotation.JsonProperty

data class EmbeddingsResponse(
    @JsonProperty("data")
    val `data`: List<Data>,
    @JsonProperty("model")
    val model: String,
    @JsonProperty("object")
    val objectX: String,
    @JsonProperty("usage")
    val usage: Usage
) {
    data class Data(
        @JsonProperty("embedding")
        val embedding: List<Double>,
        @JsonProperty("index")
        val index: Int,
        @JsonProperty("object")
        val objectX: String
    )

    data class Usage(
        @JsonProperty("prompt_tokens")
        val promptTokens: Int,
        @JsonProperty("total_tokens")
        val totalTokens: Int
    )
}