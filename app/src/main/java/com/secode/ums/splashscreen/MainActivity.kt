/*
 * Created by Muhamad Syafii
 * Saturday,24/07/2021
 * Copyright (c) 2021 by secode.id
 * All Rights Reserved
 */

package com.secode.ums.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.secode.ums.R
import com.secode.ums.webview.WebViewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}