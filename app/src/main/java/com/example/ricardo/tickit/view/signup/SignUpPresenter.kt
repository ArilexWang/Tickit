package com.example.ricardo.tickit.view.signup

import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.data.network.repository.UserRepository
import com.example.ricardo.tickit.extensions.applySchedulers
import com.example.ricardo.tickit.extensions.plusAssign
import com.example.ricardo.tickit.extensions.subscribeBy
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Ricardo on 2017/11/12.
 */

class SignUpPresenter(val view: SignUpView, val respository: UserRepository): SignUpContract.Presenter {

    protected var subscriptins = CompositeDisposable()
    //var _userDao: UserDao? = null

//
//    override fun loadUser() : List<User>{
//        val users = _userDao!!.queryBuilder()
//        val userlist = users.list()
//        for (i in userlist){
//            println(i.userName)
//        }
//        return userlist
//    }

    override fun postAccount(user: User) {
        subscriptins += respository.postAccount(user)
                .applySchedulers()
                .subscribeBy (
                        onSuccess = view::onSuccess,
                        onError = view::onError
                )
    }

    override fun start() {

    }

    override fun onViewDestroyed() {
        subscriptins.dispose()
    }

}