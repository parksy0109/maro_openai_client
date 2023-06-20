package com.maro.maro_openai_client.configs

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class HeaderConfiguration {

    @Value("\${openai.api.key}")
    private lateinit var openaiAPIKey: String

    @Bean
    fun requestInterceptor(): RequestInterceptor? {
        return RequestInterceptor { requestTemplate: RequestTemplate ->
            requestTemplate.header("Authorization", "Bearer $openaiAPIKey")
            requestTemplate.header("Content-Type", "application/json")
        }
    }

}