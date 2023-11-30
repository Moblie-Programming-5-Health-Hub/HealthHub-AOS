package com.example.healthhub.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.healthhub.R
import com.example.healthhub.databinding.ActivitySplashBinding
import com.example.healthhub.presentation.info.PersonalInfoActivity
import com.example.healthhub.util.binding.BindingActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BindingActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        loadSplashScreen()
    }

    private fun loadSplashScreen() {
        lifecycleScope.launch {
            delay(1500)
            startActivity(Intent(this@SplashActivity, PersonalInfoActivity::class.java))
            finish()
        }
    }
}