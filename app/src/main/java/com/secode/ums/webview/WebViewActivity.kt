/*
 * Created by Muhamad Syafii
 * Saturday,24/07/2021
 * Copyright (c) 2021 by secode.id
 * All Rights Reserved
 */
package com.secode.ums.webview

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import com.secode.ums.databinding.ActivityWebViewBinding
import com.secode.ums.brosur.BrosurActivity

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding
    private val URL_UMS = "https://medikasuherman.ac.id"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.webView.settings.loadsImagesAutomatically = true
        binding.webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        binding.webView.clearCache(true)
        binding.webView.settings.setSupportZoom(true)
        binding.webView.settings.loadWithOverviewMode = true
        binding.webView.settings.useWideViewPort = true
        binding.webView.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.javaScriptCanOpenWindowsAutomatically = true
        binding.webView.settings.allowContentAccess = true
        binding.webView.settings.allowFileAccess = true

        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                showLoading()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                hideLoading()
                openBrosur()
            }

        }
        binding.floatingBrosur.visibility = View.GONE
        binding.webView.loadUrl(URL_UMS)


        binding.floatingBrosur.setOnClickListener {
            val intent = Intent(this, BrosurActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            binding.webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    fun showLoading() {
        binding.progressHorizontal.visibility = View.VISIBLE
    }

    fun hideLoading() {
        binding.progressHorizontal.visibility = View.GONE
        binding.layoutProgress.visibility = View.GONE
        binding.floatingBrosur.visibility = View.VISIBLE
    }

    fun openBrosur(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Pengumuman")
        builder.setMessage("Silakahkan Tekan Buka untuk melihat Brosur kampus")
        builder.setPositiveButton("Buka") { dialog, which ->
            val move = Intent(this@WebViewActivity, BrosurActivity::class.java)
            startActivity(move)
        }
        builder.setNegativeButton("Tutup"){ dialog, which ->
            dialog.dismiss()
        }

        builder.show()
    }
}