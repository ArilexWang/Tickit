package com.example.ricardo.tickit.view.signup

import com.example.ricardo.tickit.base.BasePresenter
import com.example.ricardo.tickit.base.BaseView

/**
 * Created by Ricardo on 2017/11/13.
 */


interface SignUpContract {
    interface View : BaseView<Presenter>{

    }

    interface Presenter : BasePresenter {
        //fun loadUser():List<User>
    }
}