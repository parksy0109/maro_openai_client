package com.maro.maro_openai_client.services

import com.maro.maro_openai_client.openai.OpenAIClient
import com.maro.maro_openai_client.openai.datum.dto.EmbeddingsDto
import com.maro.maro_openai_client.openai.datum.requests.chat.ChatRequest
import com.maro.maro_openai_client.openai.datum.requests.embeddings.EmbeddingsRequest
import com.maro.maro_openai_client.openai.datum.requests.images.ImagesRequest
import com.maro.maro_openai_client.openai.datum.responses.ChatResponse
import com.maro.maro_openai_client.openai.datum.responses.ImagesResponse
import org.springframework.stereotype.Service

@Service
class OpenAIServiceImpl(
    private val openAIClient: OpenAIClient
) : OpenAIService {
    override fun getIDForModels(): List<String?> {
        return openAIClient.models().data?.map { it?.id } ?: listOf()
    }

    override fun createChatCompletion(chatRequest: ChatRequest): ChatResponse {
        return openAIClient.chat(chatRequest)
    }

    override fun createEmbeddings(embeddingsRequest: EmbeddingsRequest): List<EmbeddingsDto> {
        return openAIClient.embeddings(embeddingsRequest).data.mapIndexed { index, data ->
            EmbeddingsDto(embeddingsRequest.input[index], data.embedding)
        }
    }

    override fun createImage(imagesRequest: ImagesRequest): ImagesResponse {
        return openAIClient.images(imagesRequest)
    }
}