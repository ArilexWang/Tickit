package com.example.ricardo.tickit.view.signup

import com.example.ricardo.tickit.base.BasePresenter
import com.example.ricardo.tickit.base.BaseView
import com.example.ricardo.tickit.data.model.User

/**
 * Created by Ricardo on 2017/11/13.
 */


interface SignUpContract {
    interface View : BaseView<Presenter>{

    }

    interface Presenter : BasePresenter {
        //fun loadUser():List<User>
        fun postAccount(user: User)
    }
}