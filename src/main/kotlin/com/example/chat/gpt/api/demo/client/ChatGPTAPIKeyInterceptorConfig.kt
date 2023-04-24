package com.example.chat.gpt.api.demo.client

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.http.HttpHeaders.AUTHORIZATION

class ChatGPTAPIKeyInterceptor(private val apiKey: String) : RequestInterceptor {
    override fun apply(template: RequestTemplate) {
        template.header(AUTHORIZATION, "Bearer $apiKey")
    }
}