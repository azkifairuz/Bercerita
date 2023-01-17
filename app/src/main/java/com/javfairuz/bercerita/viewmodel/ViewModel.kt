package com.javfairuz.bercerita.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.database.*
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.javfairuz.bercerita.home.Post
import com.javfairuz.bercerita.models.DataState
import com.javfairuz.bercerita.models.DataUser
import com.javfairuz.bercerita.models.ProfileUser
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import org.w3c.dom.Document

class AppViewModel : ViewModel() {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val uid = auth.currentUser?.uid
    private val refs =
        FirebaseDatabase.getInstance("https://bercerita-5abb7-default-rtdb.asia-southeast1.firebasedatabase.app").reference

    val user = auth.currentUser?.displayName
    //user register
    fun RegisterUser(
        username: String,
        email: String,
        pass: String,
        callback: (String, Boolean) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener {

                if (it.isSuccessful) {
                    val user = auth.currentUser
                    val profilChange = userProfileChangeRequest {
                        displayName = username
                    }
                    callback("berhasil", true)
                    user!!.updateProfile(profilChange)
                } else {
                    callback("${it.exception?.message}", false)
                }

            }
    }

    //user login
    fun Login(email: String, pass: String, callback: (String, Boolean) -> Unit) {
        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callback("Berhasil Masuk", true)
                } else {
                    callback("${it.exception?.message}", false)
                }
            }

    }

    val state: MutableState<DataState> = mutableStateOf(DataState.Empty)



    //profile
    fun getDataUser() {
        state.value = DataState.Loading
        Log.e("ini","load")
        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid.toString()
        val db = FirebaseDatabase.getInstance("https://bercerita-5abb7-default-rtdb.asia-southeast1.firebasedatabase.app").reference
        val templist = mutableListOf<DataUser>()
        db.keepSynced(true)
        db.child("users")
            .child(uid)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val data = snapshot.getValue(DataUser::class.java)
                    if (data !=null) {
                        templist.addAll(listOf(data))
                        state.value = DataState.Success(templist)
                        Log.e("ini","if")
                    }else {
                        Log.e("ini","else")
                        state.value = DataState.Failure("data error")
                    }
                    Log.e("ini","$templist")


                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("ini","cancel")
                    state.value =DataState.Failure(error.message)
                }

            }

            )
    }





//    private fun getData() {
//        viewModelScope.launch {
//            state.value = getDataUser()
//            Log.e("gatau",state.value.nama)
//        }
//    }

fun pushResult(stressMetter:String, callback: (String, Boolean) -> Unit){
    refs.child("users").child(uid.orEmpty()).child("stressMeter").setValue(stressMetter).addOnCompleteListener {
        if (it.isSuccessful){
            callback("berhasil",true)
            Log.e("pushResult", "pushResult: Berhasi; ", )
        }
    }.addOnFailureListener {
        Log.e("resultFail", "pushResult:${it.message} ", )
        callback("${it.message}",false)
    }
}

fun pushData(universitas: String, semester: String, callback: (String, Boolean) -> Unit) {

    val uid = auth.currentUser?.uid.toString()
    val name = auth.currentUser?.displayName.toString()
    val user = ProfileUser(name, universitas, semester)

    if (uid == "") {
        callback("fail", false)
    } else {
        Log.e("cek", "clicked")
        refs.child("users").child(uid).setValue(user).addOnCompleteListener {
            Log.e("push data", "succes")
        }.addOnFailureListener {
            it.message?.let { it1 -> Log.e("failed", it1) }
            callback("true", false)
        }
    }
}

//logout
fun logout(callback: (String, Boolean) -> Unit) {
    auth.signOut()

    callback("berhasil logout", true)
}


var email = auth.currentUser?.email


}


