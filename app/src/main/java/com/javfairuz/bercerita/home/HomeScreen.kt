package com.javfairuz.bercerita.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javfairuz.bercerita.R
import com.javfairuz.bercerita.route.Graph

@Composable
fun Home(navHostController: NavHostController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(horizontal = 25.dp, vertical = 20.dp),
    ) {
        Text(text = stringResource(id = R.string.Header), style = MaterialTheme.typography.h1, fontSize = 30.sp)
        Text(
            text = "Mengenal diri Lebih dalam",
            style = MaterialTheme.typography.body1,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = stringResource(id = R.string.Sub), style = MaterialTheme.typography.subtitle1)
        Button(
            modifier = Modifier
                .width(150.dp)
                .padding(vertical = 10.dp),
            onClick = { navHostController.navigate(Graph.QUESTION)},
            shape = RoundedCornerShape(50),
        ) {
            Text(text = "Mulai", style = MaterialTheme.typography.button)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Baca Panduan Pengisiannya, yuk!",
            style = MaterialTheme.typography.h1,
            fontSize = 18.sp
        )
        Column(modifier = Modifier.padding(start = 15.dp)) {

            Text(
                text = "1. Gak ada jawaban yang benar atau salah, isilah dengan jujur sesuai kepribaanmu",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "2. Santai aja, tes ini gak diberi waktu",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "3. Cari tempat yang nyaman dan kondusif supaya kamu lebih fokus",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "4. Jika kamu Keluar di tengah jalan, maka seluruh proses tes dan jawaban akan hilang",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "5. Hasil tes bisa kamu dapatkan setelah mengisi semua pertanyaan dengan lengkap",
                style = MaterialTheme.typography.subtitle1
            )

        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Ingin Berecerita tapi tidak punya tempat?,yuk bercerita!",
            style = MaterialTheme.typography.h1,
            fontSize = 18.sp
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            onClick = { navHostController.navigate(Graph.BERCERITA)},
            shape = RoundedCornerShape(50),
        ) {
            Text(text = "Mulai Bercerita", style = MaterialTheme.typography.button)
        }
    }
}