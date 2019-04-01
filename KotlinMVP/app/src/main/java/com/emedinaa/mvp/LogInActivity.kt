package com.emedinaa.mvp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.emedinaa.mvp.data.Injection
import com.emedinaa.mvp.model.User
import com.emedinaa.mvp.presenter.LogInPresenter
import com.emedinaa.mvp.view.LogInContract
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity(),LogInContract.View {

    override lateinit var presenter: LogInContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        presenter=LogInPresenter(this,Injection.provideLogInRepository())

        //events
        buttonLogIn.setOnClickListener {
            presenter.logIn()
        }
    }

    override fun showLoadingView() {
        viewLoading.visibility= View.VISIBLE
    }

    override fun hideLoadingView() {
        viewLoading.visibility= View.GONE
    }

    override fun showError(error: String) {
        Toast.makeText(this, "error $error",Toast.LENGTH_LONG).show()
    }

    override fun goToMainView(user:User?) {
        val bundle:Bundle= Bundle().apply {
            putSerializable("USER",user?:"")
        }
        startActivity(Intent(this,MainActivity::class.java).putExtras(bundle))
        finish()
    }

    override fun usernameField():String {
        return editTextEmail.text.toString()
    }

    override fun passwordField():String {
        return editTextPassword.text.toString()
    }

    override fun validateForm(): Boolean {
        return editTextEmail.text.toString().isNotEmpty() && editTextPassword.text.toString().isNotEmpty()
    }

}
