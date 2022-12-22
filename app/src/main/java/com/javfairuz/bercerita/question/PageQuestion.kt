package com.javfairuz.bercerita.question

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
import com.javfairuz.bercerita.HasilTest
import com.javfairuz.bercerita.Question1
import com.javfairuz.bercerita.Question10
import com.javfairuz.bercerita.Question11
import com.javfairuz.bercerita.Question12
import com.javfairuz.bercerita.Question13
import com.javfairuz.bercerita.Question14
import com.javfairuz.bercerita.Question2
import com.javfairuz.bercerita.Question3
import com.javfairuz.bercerita.Question4
import com.javfairuz.bercerita.Question5
import com.javfairuz.bercerita.Question6
import com.javfairuz.bercerita.Question7
import com.javfairuz.bercerita.Question8
import com.javfairuz.bercerita.Question9

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

    var question = listOf(
        QuestionModel(
            question = "1.Dalam sebulan terakhir, seberapa sering kamu menjadi mudah tersingung",
            options = listOf(
                OptionsModel(
                    answer = "Pernah",
                    key = "pernah",
                    score = 1
                ),
                OptionsModel(
                    answer = "Belum Pernah",
                    key = "belum_pernah",
                    score = 1
                )
            )
        ),
        QuestionModel(
            question = "2.Dalam sebulan terakhir, seberapa ",
            options = listOf(
                OptionsModel(
                    answer = "Ga ",
                    key = "pernah",
                    score = 1
                ),
                OptionsModel(
                    answer = "Yoi",
                    key = "belum_pernah",
                    score = 1
                ),
                OptionsModel(
                    answer = "Ga ",
                    key = "pernah",
                    score = 1
                ),
                OptionsModel(
                    answer = "Yoi",
                    key = "belum_pernah",
                    score = 1
                ),
            )
        ),
        QuestionModel(
            question = "3.Dalam sebulan terakhir, seberapa ",
            options = listOf(
                OptionsModel(
                    answer = "Ga ",
                    key = "pernah",
                    score = 1
                ),
                OptionsModel(
                    answer = "Yoi",
                    key = "belum_pernah",
                    score = 1
                ),
                OptionsModel(
                    answer = "Yoi",
                    key = "belum_pernah",
                    score = 1
                )
            )
        )
    )

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
                onNext = {
                    nextQuestion()
                }
            )
        }

    }
}
