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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javfairuz.bercerita.route.Graph
import com.javfairuz.bercerita.ui.theme.BerceritaTheme

@Composable
fun PageResultTest(navHostController: NavHostController = rememberNavController(),onSubmit:(stressMetter:String)-> Unit = {setressMetter ->}) {
    var tingkatStres by remember {
        mutableStateOf("")
    }
    var solution by remember {
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

    LaunchedEffect(key1 = navHostController, block = {
        //ketika halaman dibuka ambil data score dari halaman sebelumnya jika null default =0
        score = navHostController.currentBackStackEntry?.arguments?.getString("score", "0")?.toInt()
            ?: 0

        tingkatStres = calculate()
    })
    fun submit(){
        onSubmit(tingkatStres)
        Toast.makeText(context, "berhasil upload", Toast.LENGTH_SHORT).show()
        navHostController.navigate(Graph.ARIGATOU){
            popUpTo("result"){
                inclusive = true
            }
        }
    }
    fun giveSolution() :String{
        if (tingkatStres == "Normal") return "yokatta anda Masih normal"
        if (tingkatStres == "Ringan") return "biasanya terjadi karena ada hal-hal terjadi yang diluar kendali kamu menyebabkan mentalmu kaget. Dalam hal ini, kamu bisa mencoba beberapa langkah terapi untuk meredakan emosi yang meledak-ledak, pertama, tarik napas panjang lalu keluarkan, hal ini dapat membuat tubuh menjadi rileks. kedua, berpikir positif agar otak mendukung tubuh untuk rileks, sehingga kenyataannya jauh lebih baik. terakhir, jangan lupa makan dan minum yang cukup agar kesehatan mu tetap baik ya."
        if (tingkatStres == "Sedang") return "hal ini biasanya terjadi dalam kurun waktu yang cukup lama dan sedikit mengganggu, namun masih bisa diatasi dan tidak mengganggu kehidupan sehari-hari. Dalam hal ini, kamu bisa mencoba beberapa langkah terapi untuk meredakan hal tersebut, pertama, ceritakan masalahmu pada seseorang yang kamu percaya, pastikan kalau seseorang tersebut bisa memberikan saran dan solusi juga. Kedua, lakukan meditasi untuk membuat tubuh rileks dan berpikir positif. Terakhir, tetap jaga kesehatan agar tubuh tetap sehat. Jika hal ini belum bisa membantu, segera hubungi bantuan psikolog ya. Bercerita membuka konsultasi online untuk kamu yang sedang stress. Segera mendaftar dan lakukan konsultasi ya!"
        return "semangat :("
    }
    solution = giveSolution()
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Tingkat stress anda $tingkatStres ", style = MaterialTheme.typography.h1, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = solution,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            fontSize = 10.sp
        )
        Button(
            onClick = { submit() }, modifier = Modifier
                .padding(10.dp)
                .width(120.dp)
        ) {
            Text(text = "Submit", style = MaterialTheme.typography.button)
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun test() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tingkat stress anda  ", style = MaterialTheme.typography.h1, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "biasanya terjadi karena ada hal-hal terjadi yang diluar kendali kamu menyebabkan mentalmu kaget. Dalam hal ini, kamu bisa mencoba beberapa langkah terapi untuk meredakan emosi yang meledak-ledak, pertama, tarik napas panjang lalu keluarkan, hal ini dapat membuat tubuh menjadi rileks. kedua, berpikir positif agar otak mendukung tubuh untuk rileks, sehingga kenyataannya jauh lebih baik. terakhir, jangan lupa makan dan minum yang cukup agar kesehatan mu tetap baik ya.",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            fontSize = 10.sp
        )
        Button(
            onClick = {  }, modifier = Modifier
                .padding(10.dp)
                .width(120.dp)
        ) {
            Text(text = "Submit", style = MaterialTheme.typography.button)
        }

    }
}

