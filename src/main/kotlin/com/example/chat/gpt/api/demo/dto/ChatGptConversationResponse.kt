package com.example.chat.gpt.api.demo.dto

data class ChatGPTConversationResponse(
    val id: String,
    val `object`: String,
    val created: Long,
    val model: String,
    val usage: Map<String, Int>,
    val messages: List<Message>
)
