package com.example.ricardo.tickit.extensions

import com.example.ricardo.tickit.App
import com.example.ricardo.tickit.view.common.BaseActivity

/**
 * Created by Ricardo on 2017/11/10.
 */

fun BaseActivity.loadDaoSession() = (application as App).getDaoSession()