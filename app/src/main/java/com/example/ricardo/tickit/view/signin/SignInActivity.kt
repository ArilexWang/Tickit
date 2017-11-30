package com.example.ricardo.tickit.view.signin

import android.os.Bundle
import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.data.network.repository.UserRepository
import com.example.ricardo.tickit.view.common.BaseActivity

/**
 * Created by Ricardo on 2017/11/13.
 */

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