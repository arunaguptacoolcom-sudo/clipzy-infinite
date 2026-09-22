package com.example.clifzyinfinite

data class AppPlan(
    val appName: String,
    val appType: String,
    val description: String,
    val features: List<String>,
    val screens: List<String>
)

object ClipzySmart {

    fun createPlan(idea: String): AppPlan {

        val text = idea.trim()

        val type = when {
            text.contains("game", true) -> "Game"
            text.contains("website", true) -> "Website"
            text.contains("ai", true) -> "AI Tool"
            text.contains("study", true) ||
                    text.contains("education", true) -> "Education App"
            else -> "Android App"
        }

        val features = when (type) {
            "Game" -> listOf(
                "Home",
                "Game Play",
                "Score System",
                "Levels",
                "Settings"
            )

            "Education App" -> listOf(
                "Subjects",
                "Lessons",
                "Quiz",
                "Progress",
                "Settings"
            )

            "AI Tool" -> listOf(
                "AI Chat",
                "Idea Input",
                "AI Response",
                "History",
                "Settings"
            )

            else -> listOf(
                "Home Screen",
                "Main Feature",
                "Search",
                "Profile",
                "Settings"
            )
        }

        return AppPlan(
            appName = "My New App",
            appType = type,
            description = text,
            features = features,
            screens = features
        )
    }
}