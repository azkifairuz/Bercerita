package com.javfairuz.bercerita.models



sealed class DataState {
    class Success(val data: MutableList<DataUser>):DataState()
    class Failure(val msg: String):DataState()
    object Loading : DataState()
    object Empty : DataState()

}