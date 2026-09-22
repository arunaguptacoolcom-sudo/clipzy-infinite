package com.example.clifzyinfinite

data class ClipzyMessage(
    val text: String,
    val fromUser: Boolean
)

object ClipzyConversation {

    fun respond(message: String): ClipzyMessage {

        val reply = """
            I understood your idea:

            "$message"

            I can help create:
            ✓ App features
            ✓ Screens
            ✓ Navigation
            ✓ Project structure
            ✓ Kotlin code

            Next, I'll turn this idea into an app plan.
        """.trimIndent()

        return ClipzyMessage(
            text = reply,
            fromUser = false
        )
    }
}