package com.emedinaa.mvp.data

object EndPoints {

    val url = "https://blooming-sierra-86800.herokuapp.com"

    fun logIn():String= url.plus("/api/login")
}