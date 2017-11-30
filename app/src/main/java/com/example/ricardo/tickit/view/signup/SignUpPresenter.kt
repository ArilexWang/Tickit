package com.example.ricardo.tickit.view.signup

import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.data.network.repository.UserRepository
import com.example.ricardo.tickit.extensions.applySchedulers
import com.example.ricardo.tickit.extensions.plusAssign
import com.example.ricardo.tickit.extensions.subscribeBy
import com.example.ricardo.tickit.greendao.gen.GDUserDao
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Ricardo on 2017/11/12.
 */

class SignUpPresenter(val view: SignUpView, val respository: UserRepository): SignUpContract.Presenter {

    protected var subscriptins = CompositeDisposable()

    var mUserDao: GDUserDao? = null

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