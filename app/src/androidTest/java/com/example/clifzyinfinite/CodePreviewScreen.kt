package com.example.clifzyinfinite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CodePreviewScreen(
    code: String,
    onBuild: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        Text(
            text = "⚡ Generated Code",
            color = Color.White,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color(0xFF151515))
                .padding(16.dp)
        ) {

            Text(
                text = code,
                color = Color.LightGray,
                fontSize = 13.sp,
                modifier = Modifier.verticalScroll(
                    rememberScrollState()
                )
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onBuild,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(
                text = "🚀 Build My App",
                fontSize = 16.sp
            )
        }
    }
}