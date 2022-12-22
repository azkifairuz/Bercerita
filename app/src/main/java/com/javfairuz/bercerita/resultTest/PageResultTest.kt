package com.javfairuz.bercerita.resultTest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javfairuz.bercerita.ui.theme.BerceritaTheme

@Composable
fun PageResultTest(navHostController: NavHostController= rememberNavController()){
    var tingkatStres by remember {
        mutableStateOf("")
    }
    var score by remember {
        mutableStateOf(0)
    }

    //hitung tingkat stress
    fun calculate():String{
        if(score <= 14) return "Normal"
        if(score in 15..18) return "Ringan"
        if(score in 19..26) return "Sedang"

        return "Berat"
    }

    LaunchedEffect(key1 = navHostController, block = {
        //ketika halaman dibuka ambil data score dari halaman sebelumnya jika null default =0
        score = navHostController.currentBackStackEntry?.arguments?.getString("score","0")?.toInt() ?: 0

        tingkatStres = calculate()
    })
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {



        Text(text = "tingkat stress anda adalah $tingkatStres")


        Text("$score")
    }
}

@Preview
@Composable
fun PreviewPageResultTest() {
    BerceritaTheme {
        PageResultTest()
    }
}