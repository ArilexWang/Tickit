package com.example.ricardo.tickit.view.setting

import com.example.ricardo.tickit.data.entity.GDUser
import com.example.ricardo.tickit.data.model.User
import com.example.ricardo.tickit.data.network.repository.UserRepository
import com.example.ricardo.tickit.data.network.utils.Auth
import com.example.ricardo.tickit.data.network.utils.Config
import com.example.ricardo.tickit.extensions.loadDaoSession
import com.example.ricardo.tickit.greendao.gen.GDUserDao
import java.text.SimpleDateFormat
import java.util.*
import org.json.JSONObject
import com.qiniu.android.http.ResponseInfo
import com.qiniu.android.storage.UpCompletionHandler
import com.qiniu.android.storage.UploadManager


/**
 * Created by Ricardo on 2017/12/2.
 */
class SettingPresenter (val view: SettingView): SettingContract.Presenter{


    var userDao:GDUserDao? = null

    override fun start() {

    }

    override fun postAvatar(path: String){
        val uploadManager = UploadManager()
        val sdf = SimpleDateFormat("yyyyMMddHHmmss")
        val key = "icon_" + sdf.format(Date())
        val picPath = path

        uploadManager.put(picPath, key, Auth.create(Config.ACCESS_KEY , Config.SECRET_KEY).uploadToken(Config.BUCKET_NAME), UpCompletionHandler { key, info, res ->
            if (info.isOK) {
                val headpicPath = Config.TEST_DOMAIN + key

            }
            else{

            }

        }, null)
    }

    override fun updateUserInfo(user: User) {

    }


    override fun onViewDestroyed() {

    }

    companion object {
        var tempUser: User = User()
    }

}