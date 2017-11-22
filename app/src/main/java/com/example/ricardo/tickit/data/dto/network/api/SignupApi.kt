package com.example.ricardo.tickit.data.dto.network.api

import android.renderscript.Script
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Ricardo on 2017/11/21.
 */

interface SignupApi {
    @POST("studentRegister")
    fun postAccount(
            @Field("nickname") nickname: String?,
            @Field("studentID") stdentID: String?,
            @Field("realName") realName: String?,
            @Field("mobileNumber") mobileNumber: String?,
            @Field("password") password: String?
    ): Single<String>
}
