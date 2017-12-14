package com.example.ricardo.tickit.view.profile

import android.app.Fragment
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.ricardo.tickit.R
import com.example.ricardo.tickit.view.signup.SignUpActivity
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * Created by yuhanyin on 2017/12/8.
 */
class ProfileFragment: android.support.v4.app.Fragment() {

    private var profileDetail: ImageButton? = imgProfileDetail
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Fresco.initialize(context)
        val view = inflater!!.inflate(R.layout.fragment_profile, null)
        //initView(view)
        initProfile()
        return view
    }

    private fun initView(view: View?) {
      //  profileDetial = view.findViewById(R.id.imgProfileDetail)
    }

    private fun initProfile() {


        profileDetail?.setOnClickListener {
            val intent = Intent()
            intent.setClass(this.context,ProfileInfoActivity::class.java)
            startActivity(intent)
        }

    }

    companion object {

        fun instance(): ProfileFragment {
            return ProfileFragment()
        }
    }
}