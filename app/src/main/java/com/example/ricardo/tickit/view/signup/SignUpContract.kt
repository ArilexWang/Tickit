package com.example.ricardo.tickit.view.signup

import android.icu.lang.UScript
import com.example.ricardo.tickit.base.BasePresenter
import com.example.ricardo.tickit.base.BaseView
import com.example.ricardo.tickit.data.dto.entity.User

/**
 * Created by Ricardo on 2017/11/13.
 */


interface SignUpContract {
    interface View : BaseView<Presenter>{

    }

    interface Presenter : BasePresenter {
        fun loadUser():List<User>
    }
}