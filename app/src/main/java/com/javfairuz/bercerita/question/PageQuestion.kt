package com.javfairuz.bercerita.question

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PageQuestion(navHostController: NavHostController = rememberNavController()) {
    var pager by remember {
        mutableStateOf(1)
    }
    var score by remember {
        mutableStateOf(0)
    }

    var currentQuestion by remember {
        mutableStateOf(0)
    }


    fun nextQuestion() {
        if (currentQuestion != question.size -1) {
            currentQuestion += 1
        }
    }


    Scaffold(modifier = Modifier.padding(horizontal = 20.dp), topBar = {
        IconButton(onClick = { navHostController.navigate("myapp") }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                modifier = Modifier.size(50.dp)
            )
        }
    }) {
        Column(
            Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            QuestionContent(
                question = question[currentQuestion].question,
                options = question[currentQuestion].options,
                onAnswerClicked = {
                    nextQuestion()
                }
            )
        }

    }
}
