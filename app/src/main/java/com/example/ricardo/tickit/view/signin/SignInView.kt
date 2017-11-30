package com.example.ricardo.tickit.view.signin

import com.example.ricardo.tickit.data.model.User

/**
 * Created by Ricardo on 2017/11/17.
 */

interface SignInView{

    fun onSuccess(items: List<User>)

    fun onError(error: Throwable)
}