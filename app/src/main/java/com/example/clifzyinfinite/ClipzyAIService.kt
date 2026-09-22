package com.example.clifzyinfinite

interface ClipzyAIService {

    suspend fun askClipzy(
        message: String
    ): String
}