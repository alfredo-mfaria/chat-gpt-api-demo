package com.example.chat.gpt.api.demo.controller

import com.example.chat.gpt.api.demo.dto.GitHubRepoRequest
import com.example.chat.gpt.api.demo.service.OrchestrationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class GitHubController(private val orchestrationService: OrchestrationService) {

    @PostMapping("/tech-stack")
    fun getAssistantReply(@RequestBody repo: GitHubRepoRequest): String {
        return orchestrationService.findPackageManagerAndGenerateTechStack(repo.name)
    }
}