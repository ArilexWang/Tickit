package com.example.ricardo.tickit.view.profile

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ricardo.tickit.R

/**
 * Created by yuhanyin on 2017/12/8.
 */
class ProfileFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_profile, null)
        initProfile()
        return view
    }

    private fun initProfile() {


    }

    companion object {

        fun instance(): ProfileFragment {
            return ProfileFragment()
        }
    }
}