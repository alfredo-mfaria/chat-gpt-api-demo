package com.example.chat.gpt.api.demo.common

object ResponseFormat {
  val techStackFormat = """
  @JsonInclude(NON_NULL)
  data class TechStack(
    val buildTools: List<Tool>?,
    val languages: List<Tool>?,
    val frameworks: List<Tool>?,
    val databases: List<Tool>?,
    val testingFrameworks: List<Tool>?
)

data class Tool(
    val name: String?,
    val version: String?
)
  """.trimIndent()
}