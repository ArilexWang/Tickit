package com.example.ricardo.tickit.view.home

import android.os.Build
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import com.example.ricardo.tickit.R
import com.taobao.library.VerticalBannerView

import kotlinx.android.synthetic.main.activity_home.*
import com.roughike.bottombar.OnTabSelectListener
import com.example.ricardo.tickit.R.id.bottomBar





/**
 * Created by yuhanyin on 2017/12/4.
 */
class HomeActivity :AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        println("home")

        initHome()




        bottomBar.setOnTabSelectListener { tabId ->


            if (tabId == R.id.tab_home) {
                //initHome()

            }
            if (tabId == R.id.tab_category) {

            }
            if (tabId == R.id.tab_cart) {

            }
            if (tabId == R.id.tab_profile) {

            }

        }


    }

    private fun initHome() {
        //TODO("load image and text") To change body of created functions use File | Settings | File Templates.
        val LocalImages = ArrayList<BannerModel>()

        LocalImages.add(BannerModel("1","http://img2.bimg.126.net/photo/DncDH1ZV9ObIwse7vvB5Zw==/322570323311508161.jpg"))

        LocalImages.add(BannerModel("2","http://img3.bimg.126.net/photo/hA8gbmykNcwVEmmoVTZJbg==/318348198660425043.jpg"))
        LocalImages.add(BannerModel("3","http://img8.bimg.126.net/photo/YIZRs_LIvxZNNcaxP30DbQ==/3670715171284653308.jpg"))

        val bannerAdapter = BannerAdapter(LocalImages)

        bannerView.setAdapter(bannerAdapter)
        bannerView.start()

    }



}


