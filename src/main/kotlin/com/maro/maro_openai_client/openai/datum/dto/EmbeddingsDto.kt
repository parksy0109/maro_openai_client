package com.maro.maro_openai_client.openai.datum.dto

data class EmbeddingsDto(
    val data: String,
    val embeddings: List<Double>
)