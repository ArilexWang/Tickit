package com.example.ricardo.tickit.data.network.api

import com.example.ricardo.tickit.data.dto.UserDto
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Ricardo on 2017/11/21.
 */

interface SignupApi {
    @FormUrlEncoded
    @POST("userSignUp/")
    fun postAccount(
            @Field("nickname") nickname: String,
            @Field("studentID") studentID: Long,
            @Field("realName") realName: String,
            @Field("mobileNumber") mobileNumber: Long,
            @Field("password") password: String
    ): Single<List<UserDto>>
}
