package com.example.ricardo.tickit.view.setting

import com.example.ricardo.tickit.base.BasePresenter


//接口类，将所用函数定义在这里
interface SettingContract {

    interface Presenter : BasePresenter {
        fun postAvatar(path: String)
    }
}