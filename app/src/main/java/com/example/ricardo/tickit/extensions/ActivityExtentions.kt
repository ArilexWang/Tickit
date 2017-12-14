package com.example.ricardo.tickit.extensions

import com.example.ricardo.tickit.App
import com.example.ricardo.tickit.data.entity.GDUser
import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.greendao.gen.GDUserDao
import com.example.ricardo.tickit.view.common.BaseActivity

/**
 * Created by Ricardo on 2017/11/10.
 */

fun BaseActivity.loadDaoSession() = (application as App).getDaoSession()

fun BaseActivity.saveUserToLocal(item: User, userDao: GDUserDao){
    val db = userDao!!.queryBuilder()

    val list = db.list()

    //如果本地数据库为空，插入账户数据
    if (list.isEmpty() || list.size <= 0){

        val gdUser: GDUser = GDUser(item)

        userDao.insert(gdUser)

        val sUser = userDao.load(item.id)

        println(sUser.id)
    }
    //若不为空，则删掉再插入，保持数据库只存一个账户信息
    else {
        println(list[0].id)
        userDao.deleteByKey(list[0].id)

        val db = userDao!!.queryBuilder()
        val list = db.list()
        if (list.isEmpty() || list.size <= 0){

            val gdUser: GDUser = GDUser(item)
            userDao.insert(gdUser)

            val sUser = userDao.load(item.id)
            println(sUser.id)
        }


    }
}