package com.example.chat.gpt.api.demo.dto

data class ChatGPTConversationRequest(
    val messages: List<Message>,
    val max_tokens: Int = 150,
    val n: Int = 1,
    val stop: List<String> = listOf("\n")
)

data class Message(
    val role: String,
    val content: String
)