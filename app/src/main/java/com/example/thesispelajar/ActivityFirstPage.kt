package com.example.thesispelajar

import android.content.Intent
import android.os.Bundle
import com.example.thesispelajar.common.BaseActivity
import com.example.thesispelajar.databinding.ActivityFirstPageBinding

class ActivityFirstPage : BaseActivity<ActivityFirstPageBinding>(ActivityFirstPageBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setDisplayShowHomeEnabled(false)
            setDisplayShowTitleEnabled(false)
        }
        binding.btnLogin.setOnClickListener {
            Intent(this, ActivityRegister::class.java).apply {
                startActivity(this)
            }
        }
        binding.clEmail.setOnClickListener {
            Intent(this, ActivityLogin::class.java).apply {
                startActivity(this)
            }
        }
    }
}