package com.example.ricardo.tickit.data.network.api

import com.example.ricardo.tickit.data.dto.UserDto
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface SigninApi{
    @FormUrlEncoded
    @POST("userSignIn/")
    fun postAccount(
            @Field("studentID") studentID: Long,
            @Field("password") password: String
    ): Single<List<UserDto>>
}