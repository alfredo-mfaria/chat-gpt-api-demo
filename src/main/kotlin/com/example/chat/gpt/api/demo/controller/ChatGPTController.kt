package com.example.chat.gpt.api.demo.controller

import com.example.chat.gpt.api.demo.service.ChatGPTService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatGPTController(private val chatGPTService: ChatGPTService) {

    @PostMapping("/chat")
    fun getAssistantReply(@RequestBody messages: List<Map<String, String>>): String {
        return chatGPTService.getAssistantReply(messages)
    }
}