package com.javfairuz.bercerita.models

import android.provider.ContactsContract.Profile

data class ProfileUser(
    val nama: String,
    val universitas: String,
    val semester: String,
    val stressMeter: String? = null
    )

fun ProfileUser.toFireStore():Map<String,String>{
    var data: MutableMap<String, String> = mutableMapOf()
    if(stressMeter !=null){
        data["stresMeter"]= stressMeter
    }
    data["Name"] = nama
    data["Universitas"] = universitas
    data["Semester"] = semester

    return data
}