package com.example.ricardo.tickit.view.signin


import com.example.ricardo.tickit.base.BasePresenter

import com.example.ricardo.tickit.data.network.repository.UserRepository



class SignInPresenter(val view: SignInView,val repository: UserRepository): SignInContract.Presenter{


    override fun start() {

    }

    override fun onViewDestroyed() {

    }
}
