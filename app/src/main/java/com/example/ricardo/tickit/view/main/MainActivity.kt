package com.example.ricardo.tickit.view.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ricardo.tickit.R
import com.example.ricardo.tickit.view.signin.SignInActivity
import com.example.ricardo.tickit.view.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signin_entry.setOnClickListener {
            // Finish the registration screen and return to the Login activity
            val intent = Intent(applicationContext, SignInActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_in_top )
            //第一个参数为第一个Activity离开时的动画，第二参数为所进入的Activity的动画效果

        }

        signup_entry.setOnClickListener{
            // Finish the registration screen and return to the Login activity
            val intent = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.abc_slide_in_bottom,R.anim.abc_slide_in_top )
            //第一个参数为第一个Activity离开时的动画，第二参数为所进入的Activity的动画效果
        }

    }
}
