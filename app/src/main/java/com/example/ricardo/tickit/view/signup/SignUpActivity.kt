package com.example.ricardo.tickit.view.signup

import android.os.Bundle
import com.example.ricardo.tickit.R
import com.example.ricardo.tickit.extensions.loadDaoSession
import com.example.ricardo.tickit.view.common.BaseActivity
import kotlinx.android.synthetic.main.activity_signup.*

/**
 * Created by Ricardo on 2017/11/10.
 */

class SignUpActivity : BaseActivity(),SignUpView{
    var presenter: SignUpPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //var userDao = loadDaoSession().userDao

        //presenter = SignUpPresenter(this,userDao)

        //val users = presenter!!.loadUser()

        signupBtn.setOnClickListener{ signupClick(presenter) }

    }


    fun signupClick(presenter: SignUpPresenter?){
//        //还需要处理各种空白输入
//        val users = presenter?.loadUser()
//
//        if (users!!.isEmpty()){
//
//        } else {
//            println("has")
//
//            val users2 = presenter.loadUser()
//
//        }

    }


}