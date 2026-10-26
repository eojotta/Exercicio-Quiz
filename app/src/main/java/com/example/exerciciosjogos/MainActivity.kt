package com.example.exerciciosjogos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.exerciciosjogos.screens.QuizScreen
import com.example.exerciciosjogos.screens.ResultScreen
import com.example.exerciciosjogos.screens.StartScreen
import com.example.exerciciosjogos.ui.theme.ExerciciosJogosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExerciciosJogosTheme {
                var currentScreen by remember { mutableStateOf("start") }
                var finalScore by remember { mutableStateOf(0) }

                when (currentScreen) {
                    "start" -> StartScreen(
                        onStartClick = { currentScreen = "quiz" }
                    )
                    "quiz" -> QuizScreen(
                        onFinishQuiz = { score ->
                            finalScore = score
                            currentScreen = "result"
                        }
                    )
                    "result" -> ResultScreen(
                        score = finalScore,
                        totalQuestions = 2,
                        onRestartClick = { currentScreen = "start" }
                    )
                }
            }
        }
    }
}