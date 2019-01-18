package com.kurban.flashlight.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

import com.kurban.flashlight.R

class SplashActivity : Activity() {

    companion object {
        const val SPLASH_TIME: Long = 1000 * 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, Companion.SPLASH_TIME)
    }

}
