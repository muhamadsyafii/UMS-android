/*
 * Created by Muhamad Syafii
 * Saturday,24/07/2021
 * Copyright (c) 2021 by secode.id
 * All Rights Reserved
 */
package com.secode.ums.brosur

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.secode.ums.R
import com.secode.ums.databinding.ActivityBrosurBinding


class BrosurActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBrosurBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBrosurBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {

        binding.imLeft.setOnClickListener {
            binding.imBrosur.setImageResource(R.drawable.brosur_1)
        }

        binding.imRight.setOnClickListener {
            binding.imBrosur.setImageResource(R.drawable.brosur_2)
        }
    }
}