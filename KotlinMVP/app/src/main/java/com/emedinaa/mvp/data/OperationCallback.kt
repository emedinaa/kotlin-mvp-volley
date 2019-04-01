package com.emedinaa.mvp.data

interface OperationCallback {

    fun onSuccess(obj:Any?)
    fun onError(obj:Any?)
}