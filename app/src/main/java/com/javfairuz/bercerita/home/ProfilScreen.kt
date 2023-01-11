package com.javfairuz.bercerita.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.javfairuz.bercerita.models.DataState
import com.javfairuz.bercerita.models.DataUser
import com.javfairuz.bercerita.viewmodel.AppViewModel

@Composable
fun ProfileScreen(
    name: String = "unknown",
    email: String = "unknown@gmail.com",
    universitas: String = "unknown",
    semester: String = "1",
    onLogout:() -> Unit = { },
    viewModel: AppViewModel = AppViewModel()
) {

    var nama by remember {
        mutableStateOf(name)
    }
    var email by remember {
        mutableStateOf(email)
    }
    var university by remember {
        mutableStateOf(universitas)
    }
    var tingkat by remember {
        mutableStateOf(semester)
    }
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.padding(10.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(5)
        ) {
            when(val result = viewModel.state.value){
                is DataState.Success ->{
                    SuccesScreen(email = email, dataUser = result.data)
                }

                is DataState.Loading ->{
                    ProgressDialog()
                }

                is DataState.Failure ->{
                    Text(text = result.msg, style = MaterialTheme.typography.body1)
                }

                else ->{
                    Text(text = "Error Loading data")
                }
            }

        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick =  onLogout, modifier = Modifier
            .width(200.dp)
            .padding(10.dp), shape = RoundedCornerShape(8.dp) ) {
                Text(text = "Logout")
        }
    }
}
@Preview
@Composable
fun ProgressDialog(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}


@Composable
fun SuccesScreen(
    dataUser: MutableList<DataUser>,
    email:String = "unknown"
) {
   LazyColumn{
       items(dataUser ){
               each ->
           item(user = each , email =email )
       }

   }

}
@Composable
fun item(user: DataUser,email: String){
    Column() {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color(0xFFA4BE7B)
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = user.nama,
                        style = MaterialTheme.typography.body1,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = email,
                        style = MaterialTheme.typography.h1,
                        fontSize = 17.sp
                    )
                }
            }

        }
        Spacer(modifier = Modifier.padding(5.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "Universitas",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = user.universitas,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.subtitle1
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "Semester",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.padding(5.dp))

            Text(
                text = user.semester,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.subtitle1
            )

        }


    }
}

@Preview(showSystemUi = true)
@Composable
fun ProfileView() {
    ProfileScreen()
}
