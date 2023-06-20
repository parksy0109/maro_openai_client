package com.maro.maro_openai_client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class MaroOpenaiClientApplication

fun main(args: Array<String>) {
	runApplication<MaroOpenaiClientApplication>(*args)
}
