package com.example.thesispelajar

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.thesispelajar.common.BaseActivity
import com.example.thesispelajar.databinding.ActivitySplashBinding

class ActivitySplash : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            Intent(this, ActivityFirstPage::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(this)
            }

        }, 1500)
    }
}