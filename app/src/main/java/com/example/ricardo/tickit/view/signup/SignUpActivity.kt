package com.example.ricardo.tickit.view.signup

import android.os.Bundle
import com.example.ricardo.tickit.R
import com.example.ricardo.tickit.data.dto.entity.User
import com.example.ricardo.tickit.extensions.loadDaoSession
import com.example.ricardo.tickit.greendao.gen.UserDao
import com.example.ricardo.tickit.view.common.BaseActivity

/**
 * Created by Ricardo on 2017/11/10.
 */

class SignUpActivity : BaseActivity(){


    var userDao:UserDao? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val mUser: User = User(2,"alex","alexander")

        userDao = loadDaoSession().userDao
        //userDao?.insert(mUser)

        val users = userDao!!.queryBuilder()
        val userlist = users.list()
        for (i in userlist){
            println(i.name)
        }


        println("signup")
    }


}