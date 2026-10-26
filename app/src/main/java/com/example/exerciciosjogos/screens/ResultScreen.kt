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
fun ResultScreen(score: Int, totalQuestions: Int, onRestartClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFF4FC3F7)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784)),
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text(text = "Bom trabalho!", color = Color.Black)
                }
                Text(
                    text = "Você acertou $score de $totalQuestions perguntas",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }

        Button(
            onClick = onRestartClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFEB3B)),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp)
                .width(220.dp)
        ) {
            Text(text = "JOGAR NOVAMENTE", color = Color.Black, fontWeight = FontWeight.Bold)
        }
    }
}