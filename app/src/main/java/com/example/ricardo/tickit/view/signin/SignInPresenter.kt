package com.example.ricardo.tickit.view.signin

import com.example.ricardo.tickit.data.network.repository.UserRepository

/**
 * Created by Ricardo on 2017/11/17.
 */

class SignInPresenter(val view: SignInView,val repository: UserRepository): SignInContract.Presenter{


    override fun start() {

    }

    override fun onViewDestroyed() {

    }
}