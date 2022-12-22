package com.javfairuz.bercerita.question

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.javfairuz.bercerita.ui.theme.BerceritaTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QuestionContent(
    question: String = "",
    options: List<OptionsModel> = listOf(),
    onAnswerClicked: (score:Int) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = question,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body1,
                    fontSize = 20.sp
                )


            }

        }
        items(options) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(10.dp),
                onClick = { onAnswerClicked(it.score) },
                elevation = 10.dp,
            ) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.Center) {
                    Text(text = it.answer, style = MaterialTheme.typography.subtitle1)
                }
            }
        }
    })
}

@Preview
@Composable
fun PreviewQuestionContent() {
    BerceritaTheme {
        QuestionContent(
            question = "Dalam sebulan terakhir, seberapa sering kamu menjadi mudah tersingung",
            options = listOf(
                OptionsModel(
                    answer = "Pernah",
                    score = 1,
                    key = "pernah"
                )
            )
        )
    }
}