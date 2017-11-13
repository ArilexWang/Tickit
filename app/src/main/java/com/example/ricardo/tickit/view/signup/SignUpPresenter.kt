package com.example.ricardo.tickit.view.signup

import com.example.ricardo.tickit.base.BasePresenter
import com.example.ricardo.tickit.data.dto.entity.User
import com.example.ricardo.tickit.extensions.loadDaoSession
import com.example.ricardo.tickit.greendao.gen.UserDao

/**
 * Created by Ricardo on 2017/11/12.
 */

class SignUpPresenter: SignUpContract.Presenter {

    var _view: SignUpView? = null
    var _userDao: UserDao? = null

    constructor(view: SignUpView, userDao: UserDao) {
        _userDao = userDao
        _view = checkNotNull(view)
    }

    override fun loadUser() : List<User>{
        val users = _userDao!!.queryBuilder()
        val userlist = users.list()
        for (i in userlist){
            println(i.name)
        }
        return userlist
    }


}