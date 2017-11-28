package com.example.ricardo.tickit.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ricardo.tickit.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("main")
    }
}
