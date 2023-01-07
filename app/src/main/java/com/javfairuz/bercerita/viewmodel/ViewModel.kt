package com.javfairuz.bercerita.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.javfairuz.bercerita.completeprofile.ProfileUser

class AppViewModel : ViewModel(){
    private  var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore
    private val uid = auth.currentUser?.uid

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


    //user info
    fun addUserInfo(universitas:String,semester:String,callback: (String, Boolean) -> Unit){
        val name = auth.currentUser?.displayName
        val user = ProfileUser(name.orEmpty(),universitas,semester)
        db.collection("users")
            .document(uid.orEmpty())
            .set(user)
            .addOnCompleteListener {
                 if(it.isSuccessful){
                     callback("succes",true)
                 }
            }.addOnFailureListener {
                callback("fail",false)
            }
    }

    //profile
    data class Profile(
        val nama: String,
        val universitas: String,
        val semester: String,
    )
    private val _currentUserProfile = MutableLiveData<Profile>()
    val currentUserProfile: LiveData<Profile>
        get() = _currentUserProfile
    fun getProfile(){

        db.collection("users").document(uid.orEmpty())
            .get()
            .addOnSuccessListener { documentSnap ->
                if (documentSnap != null){
                    Log.d("T", "DocumentSnapshot data:${documentSnap.data}")
                    val users = documentSnap.toObject<Profile>()
                }else{
                    Log.d("T","no such doc")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("T", "Error getting documents.", exception)
            }
    }





}
