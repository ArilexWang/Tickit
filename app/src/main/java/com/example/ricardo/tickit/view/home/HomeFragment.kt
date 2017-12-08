package com.example.ricardo.tickit.view.home

import android.app.Fragment
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_views.*

/**
 * Created by yuhanyin on 2017/12/8.
 */
public class HomeActivity :Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null){

            //TODO("load image and text") To change body of created functions use File | Settings | File Templates.
            val LocalImages = ArrayList<BannerModel>(3)

            LocalImages.add(BannerModel("1","http://img2.bimg.126.net/photo/DncDH1ZV9ObIwse7vvB5Zw==/322570323311508161.jpg"))

            LocalImages.add(BannerModel("2","http://img3.bimg.126.net/photo/hA8gbmykNcwVEmmoVTZJbg==/318348198660425043.jpg"))
            LocalImages.add(BannerModel("3","http://img8.bimg.126.net/photo/YIZRs_LIvxZNNcaxP30DbQ==/3670715171284653308.jpg"))

            val bannerAdapter = BannerAdapter(LocalImages)

            bannerView.setAdapter(bannerAdapter)
            bannerView.start()

        }



    }

    override fun On




}