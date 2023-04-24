package com.example.chat.gpt.api.demo.service

import com.example.chat.gpt.api.demo.common.Constants
import java.io.BufferedReader
import org.kohsuke.github.GHFileNotFoundException
import org.kohsuke.github.GHRepository
import org.kohsuke.github.GitHub
import org.kohsuke.github.GitHubBuilder
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GitHubService(
    @Value("\${github.orgName}")
    val orgName: String,
    @Value("\${github.access.token}")
    val pat: String,
) {

    private val logger = LoggerFactory.getLogger(GitHubService::class.java)

    fun findPackageManagerFile(repoName: String): String {
        val client = buildGitHubClient()
        val org = client.getOrganization(orgName)

        val repo = org.getRepository(repoName)

        var fileContent = ""

        for (filePath in Constants.packageManagerFiles) {
            if (getFileContent(repo, filePath)) {
                logger.info("Found $filePath")
                val inputStream = repo.getFileContent(filePath).read()
                fileContent = inputStream.bufferedReader().use(BufferedReader::readText)
                break
            }
            if (fileContent.isNotBlank()) {
                println("File content found for : $filePath")
            }
        }

        if (fileContent.isBlank()) {
            println("No package manager file found")
        }
        return fileContent
    }


    private fun getFileContent(repo: GHRepository, filePath: String): Boolean {
        return try {
            repo.getFileContent(filePath).isFile
        } catch (e: GHFileNotFoundException) {
            logger.info("Couldn't find $filePath")
            false
        }
    }

    private fun buildGitHubClient(): GitHub {
        return GitHubBuilder().withOAuthToken(pat).build()
    }
}