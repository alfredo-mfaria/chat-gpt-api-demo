package com.example.chat.gpt.api.demo.service

import com.example.chat.gpt.api.demo.client.ChatGPTClient
import com.example.chat.gpt.api.demo.common.ResponseFormat
import com.example.chat.gpt.api.demo.dto.ChatGPTRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.text.DecimalFormat

@Service
class ChatGPTPromptBuilderService(private val chatGPTClient: ChatGPTClient) {

    private val logger: Logger = LoggerFactory.getLogger(ChatGPTPromptBuilderService::class.java)
    private val decimalFormat = DecimalFormat("0.000000")

    fun getTechStackFromPackageManagerFile(fileContent: String): String {
        val prompt =
            "  \"prompt\": \"user: Give only json response that matches this data class:" +
                ResponseFormat.techStackFormat +
                    "I want you to infer the tech stack from this package manager file content:" +
                        fileContent.trimIndent() +
                    "\\nAssistant:\",\n"

        //println(prompt)
        return sendPrompt(prompt)
    }


    private fun sendPrompt(prompt: String): String {
        val requestPayload = ChatGPTRequest(prompt = prompt)
        val response = chatGPTClient.requestCompletion(requestPayload)
        logger.info("Usage in tokens: {}", response.usage.toString())
        logger.info("Usage in dollars: {}$", decimalFormat.format(response.usage["total_tokens"]?.times(0.02)?.div(1000)))

        val message = response.choices.first()["text"] as String

        return message.trim()
    }
}