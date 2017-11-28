package com.example.ricardo.tickit.data.network.repository

import com.example.ricardo.tickit.data.dto.UserDto
import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.data.network.api.SignupApi
import com.example.ricardo.tickit.data.network.provider.retrofit
import io.reactivex.Single

/**
 * Created by Ricardo on 2017/11/23.
 */

class UserRepositoryImpl : UserRepository{

    val api = retrofit.create(SignupApi::class.java)

    override fun postAccount(user: User): Single<List<User>> = api.postAccount(
            studentID = user.id.toLong(),
            nickname = user.nickName,
            realName = user.realName,
            mobileNumber = user.mobileNumber.toLong(),
            password = user.password
    ).map {
        it.map(::User)
    }
}