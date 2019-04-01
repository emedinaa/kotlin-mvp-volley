package com.emedinaa.mvp.data

import com.emedinaa.mvp.model.User

/*
{"msg":"success","status":200,"data":{"_id":"5801bc3f3b54e30300b8bc45","id":"5801bc3f3b54e30300b8bc45","username":"emedinaa@gmail.com","password":"123456","firstname":"Eduardo","lastname":"Medina","__v":0}}
 */

//request
data class LogInRaw(val username:String,val password:String)

//response
data class LogInResponse(val status:Int?,val msg:String?,val data:User?){
    companion object {
        const val SUCCESS:Int= 200
    }
    fun isSuccess():Boolean=(status==SUCCESS)
}


