package com.example.exerciciosjogos.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StartScreen(onStartClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4FC3F7)), // Azul da tela inicial
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "💬 QUIZ 💬",
                fontSize = 32.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )
            Text(
                text = "QUIZATRON 3000",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            Button(
                onClick = onStartClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFEB3B)),
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "COMEÇAR!", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}