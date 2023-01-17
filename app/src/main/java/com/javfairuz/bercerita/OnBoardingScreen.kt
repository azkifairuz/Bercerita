package com.javfairuz.bercerita

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.javfairuz.bercerita.route.Graph
import com.javfairuz.bercerita.ui.theme.Shapes
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navHostController: NavHostController = rememberNavController()
) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
    ) {

        val items = OnBoardingItems.get()
        var state = rememberPagerState(0)
        TopSection(navHostController)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            HorizontalPager(
                state = state,
                count = items.size,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .padding(12.dp)
                    ,
                verticalAlignment = Alignment.Bottom
            ) { page ->
                OnBoardingItem(items = items[page])
            }
            BottomSection(size = items.size, index = state.currentPage, onNextClick = {navHostController.navigate(Graph.AUTH)})

        }


    }
}

@Composable
fun OnBoardingItem(
    items: OnBoardingItems
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            painter = painterResource(items.image),
            contentDescription = "onboarding",
        )

        Text(
            text = stringResource(id = items.title),
            fontSize = 16.sp,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun BottomSection(
    size: Int,
    index: Int,
    onNextClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 12.dp, vertical = 1.dp)

    ) {
        Indicators(size = size, index = index)
        Spacer(modifier = Modifier.padding(60.dp))
        //button
        if (index == 2) {
            Button(
                onClick =  onNextClick,
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(150.dp),
                shape = RoundedCornerShape(20.dp)

                ) {
                Text(text = "Mulai")
            }
        }
    }
}

@Composable
fun TopSection(navHostController: NavHostController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalAlignment = Alignment.End
    )
    {
        TextButton(
            onClick = {
                navHostController.navigate(Graph.AUTH) {
                    popUpTo(Graph.ONBOARDING)
                }
            },

            ) {
            Text(text = "Skip", textAlign = TextAlign.Right)
        }
    }
}

@Composable
fun Indicators(
    size: Int = 3, index: Int = 0
) {

    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
    ) {
        repeat(size) {
            Indicator(isSelected = it == index)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {

    val width = animateDpAsState(
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
    ) {

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnBoardingPreview() {
    OnBoardingScreen()
}