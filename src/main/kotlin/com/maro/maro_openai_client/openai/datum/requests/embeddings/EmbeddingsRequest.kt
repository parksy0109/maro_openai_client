package com.maro.maro_openai_client.openai.datum.requests.embeddings


import com.fasterxml.jackson.annotation.JsonProperty

data class EmbeddingsRequest(
    @JsonProperty("model")
    val model: String = "text-embedding-ada-002",
    @JsonProperty("input")
    val input: List<String>
)