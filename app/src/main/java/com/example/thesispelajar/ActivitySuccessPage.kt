package com.example.thesispelajar

import android.content.Intent
import android.os.Bundle
import com.example.thesispelajar.common.BaseActivity
import com.example.thesispelajar.databinding.ActivitySuccessCreateAccountBinding

class ActivitySuccessPage : BaseActivity<ActivitySuccessCreateAccountBinding>(ActivitySuccessCreateAccountBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnCreatePassword.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(this)
            }
        }
    }
}