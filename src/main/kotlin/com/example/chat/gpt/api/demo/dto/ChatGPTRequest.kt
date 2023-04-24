package com.example.chat.gpt.api.demo.dto

data class ChatGPTRequest(
    val prompt: String, // the actual prompt
    val max_tokens: Int = 1500, //default is 4097, which is the max
    val n: Int = 1, // number of responses we want
    val stop: List<String>? = null, // This is a list of strings that, when encountered by the model during the generation process, will cause the generation to stop.
    val temperature: Double = 0.0 // how creative do you want the response?
)