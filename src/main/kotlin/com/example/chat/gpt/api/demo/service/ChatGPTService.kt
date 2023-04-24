package com.example.chat.gpt.api.demo.service

import com.example.chat.gpt.api.demo.client.ChatGPTClient
import com.example.chat.gpt.api.demo.dto.ChatGPTRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ChatGPTService(private val chatGPTClient: ChatGPTClient) {

    private val logger: Logger = LoggerFactory.getLogger(ChatGPTService::class.java)

    fun getAssistantReply(messages: List<Map<String, String>>): String {
        val conversation = messages.joinToString(separator = "\n") { "${it["role"]}: ${it["content"]}" }
        val prompt = "$conversation\nAssistant:"
        val requestPayload = ChatGPTRequest(prompt = prompt)
        val response = chatGPTClient.requestCompletion(requestPayload)
        logger.info("Usage: {}", response.usage.toString())
        val message = response.choices.first()["text"] as String
        return message.trim()
    }
}