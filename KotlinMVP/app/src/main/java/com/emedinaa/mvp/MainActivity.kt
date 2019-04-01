package com.emedinaa.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.emedinaa.mvp.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var user:User?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        validateExtras()

        populate()
    }

    private fun  populate(){
        textView.text= "Welcome ${user?.firstname}".plus(" ${user?.lastname}")
    }

    private fun validateExtras(){
       intent?.extras?.let {
           if(it.containsKey("USER")){
               user= it.getSerializable("USER") as User
           }
       }
    }
}
