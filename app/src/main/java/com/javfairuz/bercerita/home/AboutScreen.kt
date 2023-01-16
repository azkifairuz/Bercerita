package com.javfairuz.bercerita.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.javfairuz.bercerita.R
import com.javfairuz.bercerita.ui.theme.BerceritaTheme


@Composable
fun AboutScreen() {
    BerceritaTheme() {
        Column(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(text = "Tentang Bercerita", style = MaterialTheme.typography.h1)
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "bercerita adalah aplikasi untuk mengetahui tingkat stress di kalangan mahasiswa. aplikasi ini dibuat untuk memenuhi tugas Bahasa Indonesia Dalam pembuatan penilitian ilmiah",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "Aplikasi ini dibuat dan di rancang oleh",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h1,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.padding(20.dp))
            CardProfile(name = "Azkia Ajmal Fairuz", subText = "Developer", image = R.drawable.azki_profile)
            Spacer(modifier = Modifier.padding(20.dp))
            CardProfile(name = "Esti Mara Qanita" , subText = "Perancang dan UI designer", image = R.drawable.esti_profile)

            }

        }
}



@Composable
fun CardProfile(
    name: String = "",
    subText: String = "",
    image: Int = 0,
) {
    Card(
        modifier = Modifier
            .height(105.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .width(300.dp)
                .height(100.dp)
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(50.dp)
                    )
                    .width(50.dp)
                    .weight(1f),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = name)
                Text(text = subText, color = Color.Gray)

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevCard() {
    BerceritaTheme {
        AboutScreen()
    }
}