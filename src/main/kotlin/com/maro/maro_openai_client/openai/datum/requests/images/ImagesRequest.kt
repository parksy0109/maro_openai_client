package com.maro.maro_openai_client.openai.datum.requests.images


import com.fasterxml.jackson.annotation.JsonProperty

data class ImagesRequest(
    @JsonProperty("n")
    val n: Int?,
    @JsonProperty("prompt")
    val prompt: String?,
    @JsonProperty("size")
    val size: String?
)