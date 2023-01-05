package com.javfairuz.bercerita.signup

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest

class signupViewModel: ViewModel(){

    private  var auth: FirebaseAuth = FirebaseAuth.getInstance()


    fun RegisterUser(username: String , email: String,pass: String,callback: (String,Boolean) -> Unit){
        auth.createUserWithEmailAndPassword(email,pass)
            .addOnCompleteListener{

                if (it.isSuccessful){
                    val user = auth.currentUser
                    val profilChange = userProfileChangeRequest {
                        displayName = username
                    }
                    callback("berhasil",true)
                    user!!.updateProfile(profilChange)
                }else{
                    callback("${it.exception?.message}",false)
                }

            }
    }
}