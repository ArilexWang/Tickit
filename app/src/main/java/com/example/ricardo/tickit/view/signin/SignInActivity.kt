package com.example.ricardo.tickit.view.signin

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import com.example.ricardo.tickit.R
import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.data.network.repository.UserRepository
import com.example.ricardo.tickit.extensions.loadDaoSession
import com.example.ricardo.tickit.greendao.gen.GDUserDao
import com.example.ricardo.tickit.view.common.BaseActivity
import com.example.ricardo.tickit.view.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_signin.*

/**
 * Created by Ricardo on 2017/11/13.
 */

class SignInActivity:BaseActivity(),SignInView{
    override val presenter by lazy { SignInPresenter(this, UserRepository.get()) }

    var _userDao: GDUserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        _userDao = loadDaoSession().gdUserDao

        presenter.mUserDao = _userDao

        btn_signin.setOnClickListener{ signinBtnClick(presenter) }

        link_signup.setOnClickListener{ linkSignupClick() }

        getLocalUser(_userDao!!)

    }

    fun getLocalUser(userDao: GDUserDao){
        val db = userDao!!.queryBuilder()

        val list = db.list()

        if (!list.isEmpty()){
            val id = list[0].id
            val password = list[0].password

            input_studentID.setText(id)
            input_password.setText(password)
        }


    }

    fun linkSignupClick(){
        val intent = Intent()
        intent.setClass(this@SignInActivity, SignUpActivity::class.java)
        startActivity(intent)
    }

    fun signinBtnClick(presenter: SignInPresenter){
        if (validate()){
            val id = input_studentID.getText().toString()
            val password = input_password.getText().toString()
            presenter.postAccount(id,password)
        }
    }


    //登录成功后调用函数
    override fun onSuccess(items: List<User>) {
        println(items[0].avatar)

        //跳转界面

    }

    //登录失败后调用函数
    override fun onError(error: Throwable) {


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
}