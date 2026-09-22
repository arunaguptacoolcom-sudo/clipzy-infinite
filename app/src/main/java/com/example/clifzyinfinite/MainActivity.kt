package com.example.clifzyinfinite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ClipzyInfiniteApp()
        }
    }
}

@Composable
fun ClipzyInfiniteApp() {

    var idea by remember { mutableStateOf("") }
    var showPlan by remember { mutableStateOf(false) }
    var showCode by remember { mutableStateOf(false) }
    var generatedCode by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {

        if (showCode) {

            CodePreviewScreen(
                code = generatedCode,
                onBuild = {
                    // APK build system will be connected later
                }
            )

        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item {

                    Text(
                        text = "∞",
                        color = Color.White,
                        fontSize = 58.sp
                    )

                    Text(
                        text = "Clipzy Infinite",
                        color = Color.White,
                        fontSize = 30.sp
                    )

                    Text(
                        text = "Clipzy Smart • AI App Builder",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }

                item {

                    Text(
                        text = "What do you want to build?",
                        color = Color.White,
                        fontSize = 21.sp
                    )

                    OutlinedTextField(
                        value = idea,
                        onValueChange = { idea = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text("Describe your app idea...")
                        },
                        minLines = 5,
                        shape = RoundedCornerShape(20.dp)
                    )
                }

                item {

                    Button(
                        onClick = {

                            if (idea.isNotBlank()) {

                                val plan =
                                    ClipzySmart.createPlan(idea)

                                generatedCode =
                                    ClipzyCodeGenerator.generate(plan)

                                showPlan = true
                                showCode = true
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(58.dp),
                        shape = RoundedCornerShape(18.dp)
                    ) {

                        Text(
                            text = "⚡ Build My App",
                            fontSize = 17.sp
                        )
                    }
                }

                item {

                    Text(
                        text = "Create anything",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }

                item {
                    FeatureCard("📱", "Android App")
                }

                item {
                    FeatureCard("🌐", "Website")
                }

                item {
                    FeatureCard("🎮", "Game")
                }

                item {
                    FeatureCard("🤖", "AI Tool")
                }

                item {
                    FeatureCard("🛠️", "Utility App")
                }

                item {
                    FeatureCard("📚", "Education App")
                }
            }
        }
    }
}

@Composable
fun FeatureCard(
    icon: String,
    title: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF151515)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {

        Row(
            modifier = Modifier.padding(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = icon,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = title,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}