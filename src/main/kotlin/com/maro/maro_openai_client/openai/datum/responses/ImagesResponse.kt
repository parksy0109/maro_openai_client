package com.maro.maro_openai_client.openai.datum.responses


import com.fasterxml.jackson.annotation.JsonProperty

data class ImagesResponse(
    @JsonProperty("created")
    val created: Int?,
    @JsonProperty("data")
    val `data`: List<Data?>?
) {
    data class Data(
        @JsonProperty("url")
        val url: String?
    )
}