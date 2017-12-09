package com.example.ricardo.tickit.view.signin

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import com.example.ricardo.tickit.R
import com.example.ricardo.tickit.base.BasePresenter
import com.example.ricardo.tickit.data.network.repository.UserRepository
import com.example.ricardo.tickit.view.common.BaseActivity
import com.example.ricardo.tickit.view.signup.SignUpActivity
import com.example.ricardo.tickit.view.signup.SignUpPresenter
import kotlinx.android.synthetic.main.activity_signin.*

import android.os.Bundle
import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.data.network.repository.UserRepository
import com.example.ricardo.tickit.view.common.BaseActivity


class SignInActivity: BaseActivity() {

    override val presenter by lazy { SignInPresenter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        //input_studentID.addTextChangedListener(new TextWatcher)

        btn_signin.setOnClickListener{ Signin() }

        link_signup.setOnClickListener{
                val intent = Intent()
                intent.setClass(this@SignInActivity,SignUpActivity::class.java)
                startActivity(intent)
        }


    }

    private fun Signin() {
        //Log( "Login")

        if (!validate()) {
            onSigninFailed()
            return
        }

        btn_signin.setEnabled(false)


        //val progressbar = ProgressBar()

        //use of progressdialog
//        val progressDialog = ProgressDialog(this,R.style.AppTheme)
//
//
//                //ProgressDialog(this@LoginActivity, R.style.AppTheme_Dark_Dialog)
//        progressDialog.isIndeterminate = true
//        progressDialog.setMessage("Authenticating...")
//        progressDialog.show()
//
//        val inputID = input_studentID.getText().toString()
//        val password = input_password.getText().toString()

        android.os.Handler().postDelayed({
                    // On complete call either onLoginSuccess or onLoginFailed
                    onLoginSuccess()
                    // onLoginFailed();

                    //progressDialog.dismiss()

                }, 3000)
    }

    private fun onLoginSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    fun validate(): Boolean {
        var valid = true

        val inputID = input_studentID.getText().toString()
        val password = input_password.getText().toString()

        if (inputID.isEmpty()|| ! Patterns.PHONE.matcher(inputID).matches()) {

            //|| !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
            input_studentID.setError("enter a valid email address !")
            valid = false
        } else {
            input_studentID.setError(null)
        }

        //password should be 4-10
        if (password.isEmpty() || password.length < 4 || password.length > 10) {
            input_password.setError("between 4 and 10 alphanumeric characters")
            valid = false
        } else {
            input_password.setError(null)
        }

        return valid
    }

    private fun onSigninFailed(){

class SignInActivity:BaseActivity(),SignInView{
    override val presenter by lazy { SignInPresenter(this, UserRepository.get()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //登录成功后调用函数
    override fun onSuccess(items: List<User>) {

    }

    //登录失败后调用函数
    override fun onError(error: Throwable) {



    }

}