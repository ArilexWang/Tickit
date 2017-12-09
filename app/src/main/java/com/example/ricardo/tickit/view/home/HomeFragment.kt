package com.example.ricardo.tickit.view.home

import android.app.Fragment
import android.os.Bundle
import android.support.annotation.Nullable
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.ricardo.tickit.R
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * Created by yuhanyin on 2017/12/8.
 */
 class HomeFragment: Fragment() {

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle): View? {
        val view = inflater.inflate(R.layout.fragment_home, null)
        initBanner()
        return view
    }

    private fun initBanner() {
        val LocalImages = ArrayList<BannerModel>(3)

        LocalImages.add(BannerModel("1","http://img2.bimg.126.net/photo/DncDH1ZV9ObIwse7vvB5Zw==/322570323311508161.jpg"))

        LocalImages.add(BannerModel("2","http://img3.bimg.126.net/photo/hA8gbmykNcwVEmmoVTZJbg==/318348198660425043.jpg"))
        LocalImages.add(BannerModel("3","http://img8.bimg.126.net/photo/YIZRs_LIvxZNNcaxP30DbQ==/3670715171284653308.jpg"))

        val bannerAdapter = BannerAdapter(LocalImages)

        bannerView.setAdapter(bannerAdapter)
        bannerView.start()
    }

    companion object {

        fun instance(): HomeFragment {
            return HomeFragment()
        }
    }






}