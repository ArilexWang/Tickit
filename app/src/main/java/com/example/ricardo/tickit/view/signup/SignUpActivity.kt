package com.example.ricardo.tickit.view.signup

import android.os.Bundle
import com.example.ricardo.tickit.R
import com.example.ricardo.tickit.data.dto.UserDto
import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.data.network.repository.UserRepository
import com.example.ricardo.tickit.view.common.BaseActivity
import kotlinx.android.synthetic.main.activity_signup.*

/**
 * Created by Ricardo on 2017/11/10.
 */

class SignUpActivity : BaseActivity(),SignUpView{

    override val presenter by lazy { SignUpPresenter(this, UserRepository.get()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        signupBtn.setOnClickListener{ signupClick(presenter) }

    }

    fun signupClick(presenter: SignUpPresenter?){
        println("click")

        val mUser = User("1111111","2327","1127","1234567811","22222")
        
        presenter!!.postAccount(mUser)

    }

    //注册成功后调用的函数，用户信息存入greenDao,跳转界面
    override fun onSuccess(items: List<User>) {
        println(items[0].avatar)

    }

    //注册失败，给出一系列提示
    override fun onError(error: Throwable) {
        println(error)
    }

}