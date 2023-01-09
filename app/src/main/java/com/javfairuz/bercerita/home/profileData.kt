package com.javfairuz.bercerita.home

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.toObject

data class Post(
    val nama: String,
    val universitas: String,
    val semester: String,
    val stressmeter:String,
){
    companion object {
        fun toObject(doc: DocumentSnapshot): Post? {
            val item = doc.toObject<Post>()
            item?.nama
            return item
        }
    }
}