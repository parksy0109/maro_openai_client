package com.maro.maro_openai_client.openai

import com.maro.maro_openai_client.configs.HeaderConfiguration
import com.maro.maro_openai_client.openai.datum.requests.chat.ChatRequest
import com.maro.maro_openai_client.openai.datum.requests.embeddings.EmbeddingsRequest
import com.maro.maro_openai_client.openai.datum.responses.ChatResponse
import com.maro.maro_openai_client.openai.datum.responses.EmbeddingsResponse
import com.maro.maro_openai_client.openai.datum.responses.ModelResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "OpenAIClient", url = "https://api.openai.com", configuration = [HeaderConfiguration::class])
interface OpenAIClient {

    @RequestMapping(method = [RequestMethod.GET], value = ["/v1/models"])
    fun models(): ModelResponse

    @RequestMapping(method = [RequestMethod.POST], value = ["/v1/chat/completions"])
    fun chat(chatRequest: ChatRequest): ChatResponse

    @RequestMapping(method = [RequestMethod.POST], value = ["/v1/embeddings"])
    fun embeddings(embeddingsRequest: EmbeddingsRequest): EmbeddingsResponse

}