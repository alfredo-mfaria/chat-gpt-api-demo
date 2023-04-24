package com.example.chat.gpt.api.demo.client

import com.example.chat.gpt.api.demo.config.ChatGPTAPIKeyInterceptorConfig
import com.example.chat.gpt.api.demo.dto.ChatGPTConversationRequest
import com.example.chat.gpt.api.demo.dto.ChatGPTConversationResponse
import com.example.chat.gpt.api.demo.dto.ChatGPTRequest
import com.example.chat.gpt.api.demo.dto.ChatGPTResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "chatGPTClient", url = "\${chatgpt.api.url}",
    configuration = [ChatGPTAPIKeyInterceptorConfig::class])
interface ChatGPTClient {
    @PostMapping("/completions")
    fun requestCompletion(
        @RequestBody requestPayload: ChatGPTRequest
    ): ChatGPTResponse

    @PostMapping("/conversations")
    fun requestConversation(
        @RequestBody requestPayload: ChatGPTConversationRequest
    ): ChatGPTConversationResponse
}