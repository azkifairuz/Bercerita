package com.javfairuz.bercerita.resultTest

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javfairuz.bercerita.ui.theme.BerceritaTheme

@Composable
fun PageResultTest(navHostController: NavHostController = rememberNavController(),onSubmit:(stressMetter:String)-> Unit = {setressMetter ->}) {
    var tingkatStres by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    var score by remember {
        mutableStateOf(0)
    }

    //hitung tingkat stress
    fun calculate(): String {
        if (score <= 14) return "Normal"
        if (score in 15..18) return "Ringan"
        if (score in 19..25) return "Sedang"
        return "Berat"
    }
    fun submit(){
        onSubmit(tingkatStres)
        Toast.makeText(context, "berhasil upload", Toast.LENGTH_SHORT).show()

    }
    LaunchedEffect(key1 = navHostController, block = {
        //ketika halaman dibuka ambil data score dari halaman sebelumnya jika null default =0
        score = navHostController.currentBackStackEntry?.arguments?.getString("score", "0")?.toInt()
            ?: 0

        tingkatStres = calculate()
    })

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(text = "Tingkat stress anda  $tingkatStres", style = MaterialTheme.typography.h1)
        Button(
            onClick = { submit() }, modifier = Modifier
                .padding(10.dp)
                .width(120.dp)
        ) {
            Text(text = "Submit", style = MaterialTheme.typography.button)
        }

    }
}

