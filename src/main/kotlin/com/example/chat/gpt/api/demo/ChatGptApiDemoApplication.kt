package com.example.chat.gpt.api.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class ChatGptApiDemoApplication

fun main(args: Array<String>) {
	runApplication<ChatGptApiDemoApplication>(*args)
}
