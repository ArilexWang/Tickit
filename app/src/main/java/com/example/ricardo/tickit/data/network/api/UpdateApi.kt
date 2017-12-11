package com.example.ricardo.tickit.data.network.api

import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Ricardo on 2017/12/11.
 */
interface UpdateApi {
    @FormUrlEncoded
    @POST("changeUserInfo/")
    fun UpdateUserMsg(
            @Field("nickname") nickname: String,
            @Field("studentID") studentID: Long,
            @Field("realName") realName: String,
            @Field("mobileNumber") mobileNumber: Long,
            @Field("password") password: String,
            @Field("avatar") avatar: String
    ): Single<String>
}