package com.example.ricardo.tickit.data.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.example.ricardo.tickit.data.dto.UserDto
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ricardo on 2017/11/27.
 */

@SuppressLint("ParceCreator")
@Parcelize
class User(
        var id: String,
        var nickName: String,
        var realName: String,
        var mobileNumber: String,
        var password: String,
        var avatar: String
) :Parcelable {
    constructor(dto: UserDto): this(
            id = dto.pk,
            nickName = dto.fields.nickname,
            realName = dto.fields.realName,
            mobileNumber = dto.fields.mobileNumber,
            password = dto.fields.password,
            avatar = dto.fields.avatar

    )
    constructor(id: String, nickName: String,realName: String, mobileNumber: String,password: String):
            this(id, nickName, realName, mobileNumber, password, "")

    constructor():this("","","","","")
}