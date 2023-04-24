package com.example.chat.gpt.api.demo.service

import org.springframework.stereotype.Service

@Service
class OrchestrationService(
    private val gitHubService: GitHubService,
    private val chatGPTPromptBuilderService: ChatGPTPromptBuilderService
) {

    fun findPackageManagerAndGenerateTechStack(repoName: String): String {
        val packageManagerContent = gitHubService.findPackageManagerFile(repoName)

        return chatGPTPromptBuilderService.getTechStackFromPackageManagerFile(packageManagerContent)
    }
}