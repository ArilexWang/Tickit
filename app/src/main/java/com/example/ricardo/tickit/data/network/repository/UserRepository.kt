package com.example.ricardo.tickit.data.network.repository

import com.example.ricardo.tickit.data.dto.UserDto
import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.data.network.provider.Provider
import io.reactivex.Single

/**
 * Created by Ricardo on 2017/11/22.
 */

interface UserRepository{
    fun postAccount(user: User): Single<List<User>>
    fun signIn(studentID: String, password: String): Single<List<User>>

    companion object : Provider<UserRepository>() {
        override fun creator() =  UserRepositoryImpl()
    }
}