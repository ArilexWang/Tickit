package com.example.ricardo.tickit.view.signup

import android.os.Bundle
import com.example.ricardo.tickit.R
import com.example.ricardo.tickit.data.entity.GDUser
import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.data.network.repository.UserRepository
import com.example.ricardo.tickit.extensions.loadDaoSession
import com.example.ricardo.tickit.greendao.gen.GDUserDao
import com.example.ricardo.tickit.view.common.BaseActivity
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : BaseActivity(),SignUpView{

    override val presenter by lazy { SignUpPresenter(this, UserRepository.get()) }

    var _userDao: GDUserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        _userDao = loadDaoSession().gdUserDao

        presenter.mUserDao = _userDao

        signupBtn.setOnClickListener{ signupClick(presenter) }

    }


    //按钮点击处理事件
    fun signupClick(presenter: SignUpPresenter?){
        println("click")

        val mUser = User("1111112","2327","1127","1234567812","22222")

        presenter!!.postAccount(mUser)

    }

    //注册成功后调用的函数，用户信息存入greenDao,跳转界面
    override fun onSuccess(items: List<User>) {

        println(items[0].avatar)

        val user = items[0]

        saveUserToLocal(user, presenter.mUserDao!!)

    }

    //注册失败，给出一系列提示
    override fun onError(error: Throwable) {
        println(error)
    }


    //存入本地服务器
    override fun saveUserToLocal(item: User, userDao: GDUserDao){
        val db = userDao!!.queryBuilder()

        val list = db.list()

        //如果本地数据库为空，插入账户数据
        if (list.isEmpty() || list.size <= 0){
            println(" is Empty ")

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



}