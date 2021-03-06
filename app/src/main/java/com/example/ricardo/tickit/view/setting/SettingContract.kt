package com.example.ricardo.tickit.view.setting

import com.example.ricardo.tickit.base.BasePresenter
import com.example.ricardo.tickit.data.model.User


//接口类，将所用函数定义在这里
interface SettingContract {

    interface Presenter : BasePresenter {
        //发送照片到七牛云
        fun postAvatar(path: String)

        //更新用户信息
        fun updateUserInfo(user: User)
    }
}