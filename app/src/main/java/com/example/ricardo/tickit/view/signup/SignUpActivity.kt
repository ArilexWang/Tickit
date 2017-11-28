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

        val mUser = User("111110","2327","1127","123456780","22222")
        
        presenter!!.postAccount(mUser)


    }

    override fun show(items: List<User>) {
        println(items[0].mobileNumber)
    }

    override fun showError(error: Throwable) {
        println(error)
    }

}