package com.example.ricardo.tickit.view.setting

import com.example.ricardo.tickit.data.network.utils.Auth
import com.example.ricardo.tickit.data.network.utils.Config
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

        }, null)
    }


    override fun onViewDestroyed() {

    }

}