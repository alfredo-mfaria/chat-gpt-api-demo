package com.example.chat.gpt.api.demo.dto

data class ChatGPTResponse(
    val id: String,
    val `object`: String,
    val created: Long,
    val model: String,
    val usage: Map<String, Int>,
    val choices: List<Map<String, Any>>
)