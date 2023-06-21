package com.maro.maro_openai_client.services

import com.maro.maro_openai_client.openai.datum.dto.EmbeddingsDto
import com.maro.maro_openai_client.openai.datum.requests.chat.ChatRequest
import com.maro.maro_openai_client.openai.datum.requests.embeddings.EmbeddingsRequest
import com.maro.maro_openai_client.openai.datum.requests.images.ImagesRequest
import com.maro.maro_openai_client.openai.datum.responses.ChatResponse
import com.maro.maro_openai_client.openai.datum.responses.ImagesResponse

interface OpenAIService {
    fun getIDForModels(): List<String?>
    fun createChatCompletion(chatRequest: ChatRequest): ChatResponse
    fun createEmbeddings(embeddingsRequest: EmbeddingsRequest): List<EmbeddingsDto>
    fun createImage(imagesRequest: ImagesRequest): ImagesResponse
}