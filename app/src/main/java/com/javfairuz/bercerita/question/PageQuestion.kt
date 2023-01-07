package com.javfairuz.bercerita.question

import android.util.Log
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
import com.javfairuz.bercerita.route.Graph

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
        //jika masih di pertanyaan lanjut ke pertanyaan selanjutnya
        if (currentQuestion != question.size - 1) {
            currentQuestion += 1
            return
        }
        //pindah ke result page dengan membawa data score
        if(currentQuestion == question.size -1){
            navHostController.navigate("result/${score}")
        }
    }

    //hitung score nya
    fun calculateScore(data: OptionsModel) {
        score += data.score
        Log.e("score",score.toString())
        nextQuestion()
    }


    Scaffold(modifier = Modifier.padding(horizontal = 20.dp), topBar = {
        IconButton(onClick = { navHostController.navigate(Graph.HOME) }) {
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
                    calculateScore(it)
                }
            )

        }

    }
}
