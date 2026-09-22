package com.example.clifzyinfinite

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

object ClipzyNetwork {

    suspend fun sendMessage(message: String): String {

        return withContext(Dispatchers.IO) {

            try {

                val url = URL("http://10.0.2.2:8080/chat")

                val connection =
                    url.openConnection() as HttpURLConnection

                connection.requestMethod = "POST"
                connection.connectTimeout = 10000
                connection.readTimeout = 10000
                connection.doOutput = true

                connection.setRequestProperty(
                    "Content-Type",
                    "application/json"
                )

                val json =
                    """{"message":"${message.replace("\"", "\\\"")}"}"""

                connection.outputStream.use { output ->
                    output.write(json.toByteArray())
                }

                val responseCode =
                    connection.responseCode

                if (responseCode == 200) {

                    connection.inputStream
                        .bufferedReader()
                        .use { it.readText() }

                } else {

                    "Backend response error: $responseCode"
                }

            } catch (e: Exception) {

                "Clipzy backend अभी connected नहीं है."
            }
        }
    }
}