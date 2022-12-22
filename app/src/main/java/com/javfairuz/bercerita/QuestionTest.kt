package com.javfairuz.bercerita

import android.text.Layout.Alignment
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Question(navHostController: NavHostController = rememberNavController()) {
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
                .fillMaxSize(), verticalArrangement = Arrangement.Center , horizontalAlignment = CenterHorizontally) {
            var pager by remember {
                mutableStateOf(1)
            }
            var score by remember {
                mutableStateOf(0)
            }

            fun tidakPernah() {
                pager +=1
                score += 0
            }

            fun pernah() {
                pager +=1
                score += 1
            }

            fun sering() {
                pager +=1
                score += 2

            }

            fun selalu() {
                pager +=1
                score += 3
            }

            when(pager){
                1 -> Question1()
                2 -> Question2()
                3 -> Question3()
                4 -> Question4()
                5 -> Question5()
                6 -> Question6()
                7 -> Question7()
                8 -> Question8()
                9 -> Question9()
                10 -> Question10()
                11 -> Question11()
                12 -> Question12()
                13 -> Question13()
                14 -> Question14()
                else -> HasilTest(Score = score)
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(10.dp),
                onClick = { tidakPernah() },
                elevation = 10.dp,
            ) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.Center) {
                    Text(text = "Tidak Pernah", style = MaterialTheme.typography.subtitle1)
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(10.dp),
                onClick = { pernah() },
                elevation = 10.dp,
            ) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.Center) {
                    Text(text = "Pernah", style = MaterialTheme.typography.subtitle1)
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(10.dp)
                    .clickable { sering() },
                elevation = 10.dp,
            ) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.Center) {
                    Text(text = "Sering", style = MaterialTheme.typography.subtitle1)
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(10.dp)
                    .clickable { selalu() },
                elevation = 10.dp,
            ) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.Center) {
                    Text(text = "Selalu", style = MaterialTheme.typography.subtitle1)
                }
            }



        }

    }
}

@Composable
fun HasilTest(Score:Int){
    var tingkatStres = ""
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = CenterHorizontally) {
        if(Score <=14){
            tingkatStres = "normal"
        }else if (Score >14 && Score <19 ){
            tingkatStres = "ringan"
        }else if (Score > 18 && Score < 26){
            tingkatStres = "sedang"
        }else if (Score >27){
            tingkatStres = "berat"
        }


        Text(text = "tingkat stress anda adalah $tingkatStres")


        Text("$Score")
    }
}

@Composable
fun Question1() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu menjadi marah karena hal hal kecil/spele ",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 20.sp
        )


    }
}

@Composable
fun Question2() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu berekasi berlebihan pada situasi",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question3() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu merasa kesulitan untuk relaksasi atau bersantai",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question4() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu mudah merasa kesal terhadap sesuatu",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question5() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu merasa mudah menghabiskan energi karena cemas",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question6() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu merasa menjadi tidak sabar-an`",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question7() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu menjadi mudah tersingung",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question8() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu merasa sulit untuk beristirahat",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question9() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu menjadi mudah marah",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question10() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu merasa kesulitan untuk menenangkan diri setelah ada sesuatu yang mengganggu",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question11() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu mudah terdistraksi ketika sedang melakukan sesuatu",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question12() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu berada pada keadaan yang menegangkan",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question13() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu tidak menoleransi hal apapun yang menghalangimu saat sedang melakukan sesuatu",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}

@Composable
fun Question14() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Dalam sebulan terakhir, seberapa sering kamu mudah merasa gelisah",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp
        )


    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Questionprev() {
    Question()
}