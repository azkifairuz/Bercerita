package com.javfairuz.bercerita.models

import android.provider.ContactsContract.Profile

data class ProfileUser(
    val nama: String,
    val universitas: String,
    val semester: String,
    val stressMeter: String? = ""
    )

fun ProfileUser.toFireStore():Map<String,String>{
    var data: MutableMap<String, String> = mutableMapOf()

    data["stresMeter"]= stressMeter.toString()
    data["Name"] = nama
    data["Universitas"] = universitas
    data["Semester"] = semester

    return data
}