package com.example.chat.gpt.api.demo.config

import com.example.chat.gpt.api.demo.client.ChatGPTAPIKeyInterceptor
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders.*

@Configuration
class ChatGPTAPIKeyInterceptorConfig {
    @Bean
    fun chatGPTAPIKeyInterceptor(@Value("\${chatgpt.api.key}") apiKey: String): ChatGPTAPIKeyInterceptor {
        return ChatGPTAPIKeyInterceptor(apiKey)
    }
}