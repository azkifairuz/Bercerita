package com.javfairuz.bercerita.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest

class AppViewModel : ViewModel(){
    private  var auth: FirebaseAuth = FirebaseAuth.getInstance()



    //user register
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
    //user login
    fun Login (email:String,pass:String,callback: (String,Boolean) -> Unit){
        auth.signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    callback("Berhasil Masuk",true)
                }else{
                    callback("${it.exception?.message}",false)
                }
            }

    }
}
