package com.javfairuz.bercerita.signin

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel:ViewModel() {

    private var auth : FirebaseAuth = FirebaseAuth.getInstance()

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