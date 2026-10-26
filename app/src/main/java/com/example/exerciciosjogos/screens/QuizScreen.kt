package com.example.exerciciosjogos.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

@Composable
fun QuizScreen(onFinishQuiz: (Int) -> Unit) {
    val questions = listOf(
        Question("Qual é a capital da França?", listOf("Londres", "Berlim", "Paris", "Madri"), 2),
        Question("Qual planeta é conhecido como planeta vermelho?", listOf("Vênus", "Marte", "Júpiter", "Saturno"), 1)
    )

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }

    val question = questions[currentQuestionIndex]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF48FB1)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF81C784)),
                modifier = Modifier.padding(bottom = 24.dp)
            ) {
                Text(text = "Pergunta ${currentQuestionIndex + 1} de ${questions.size}", color = Color.Black)
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = question.text,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    question.options.forEachIndexed { index, option ->
                        OutlinedButton(
                            onClick = {
                                if (index == question.correctAnswerIndex) {
                                    score++
                                }
                                if (currentQuestionIndex < questions.size - 1) {
                                    currentQuestionIndex++
                                } else {
                                    onFinishQuiz(score)
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Text(text = option, color = Color.Black)
                        }
                    }
                }
            }
        }
    }
}