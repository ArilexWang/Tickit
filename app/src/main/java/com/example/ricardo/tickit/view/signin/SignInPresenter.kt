package com.example.ricardo.tickit.view.signin

import com.example.ricardo.tickit.data.network.repository.UserRepository
import com.example.ricardo.tickit.extensions.applySchedulers
import com.example.ricardo.tickit.extensions.plusAssign
import com.example.ricardo.tickit.extensions.subscribeBy
import com.example.ricardo.tickit.greendao.gen.GDUserDao
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Ricardo on 2017/11/17.
 */

class SignInPresenter(val view: SignInView,val respository: UserRepository): SignInContract.Presenter{

    protected var subscriptins = CompositeDisposable()

    var mUserDao: GDUserDao? = null


    override fun start() {

    }

    override fun postAccount(studentID: String, password: String) {
        subscriptins += respository.signIn(studentID,password)
                .applySchedulers()
                .subscribeBy (
                        onSuccess = view::onSuccess,
                        onError = view::onError
                )
    }

    override fun onViewDestroyed() {
        subscriptins.dispose()
    }
}