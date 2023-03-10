package com.javfairuz.bercerita.completeprofile

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javfairuz.bercerita.route.Graph

@Composable
fun CompleteProfileScreen(
    navHostController: NavHostController = rememberNavController(),
    onSubmit:(univ:String,semester:String) -> Unit = {univ,semester->}
) {

    var university by remember {
        mutableStateOf("unknown")
    }

    var mExpanded by remember {
        mutableStateOf(false)
    }
    var listSemester = listOf("1", "2", "3", "4", "5", "6", "7", "8")

    var selectedSemester by remember { mutableStateOf(listSemester[0]) }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (mExpanded) Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown
    fun addDataUser(){
        onSubmit(university,selectedSemester)
        navHostController.navigate(Graph.HOME)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 40.dp),
        Arrangement.Top,
        Alignment.CenterHorizontally
    ) {

        Text(
            text = "Biodata",
            style = MaterialTheme.typography.h1,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Kami Memerlukan data ini untuk  survey kami", textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            value = university,
            onValueChange = { university = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "Universitas"
                )
            })
        Spacer(modifier = Modifier.padding(20.dp))
        OutlinedTextField(
            value = selectedSemester,
            readOnly = true,
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                },
            label = { Text(text = "Semester") },
            trailingIcon = {
                Icon(icon, "", modifier = Modifier.clickable { mExpanded = !mExpanded })
            }
        )

        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier.width(
                with(
                    LocalDensity.current
                ) {
                    textFieldSize.width.toDp()
                }
            )
        ) {
            listSemester.forEach { semester ->

                DropdownMenuItem(onClick = {

                    selectedSemester = semester
                    mExpanded = false

                }) {
                    Text(text = semester)
                }

            }
        }

        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = { addDataUser() },
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 10.dp)
                .width(150.dp),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(text = "submit", style = MaterialTheme.typography.button)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCompProf() {
    CompleteProfileScreen()
}