package com.javfairuz.bercerita

import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.Right
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.Indicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun OnBoardingScreen(
    navHostController: NavHostController = rememberNavController()
) {

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ){
            TextButton(
                onClick = { navHostController.navigate("login") {
                    popUpTo("OnBoarding")
                } },
                
            ) {
                Text(text = "Skip", textAlign = TextAlign.Right, modifier = Modifier.fillMaxWidth())
            }
        }
        Indicators()
//        Image(
//            painter = painterResource(id = R.drawable.eula),
//            contentDescription = "",
//            modifier = Modifier.width(300.dp)
//        )
//        Spacer(modifier = Modifier.padding(20.dp))
//        Text(text = "Deskripsi")
//        Spacer(modifier = Modifier.padding(20.dp))


    }
}

@Composable
@Preview
fun Indicators(){
    val size = 3
    val index = 0

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        repeat(size){
            Indicator(isSelected = it == index )
        }
    }
}

@Composable
fun Indicator(isSelected:Boolean){

    val  width = animateDpAsState(
        targetValue = 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )
    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground.copy(
                    0.5f
                )
            )
    ){

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnBoardingPreview() {
    OnBoardingScreen()
}