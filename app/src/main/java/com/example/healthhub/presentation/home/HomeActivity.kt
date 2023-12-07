package com.example.healthhub.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.healthhub.R
import com.example.healthhub.common.ViewModelFactory
import com.example.healthhub.databinding.ActivityHomeBinding
import com.example.healthhub.presentation.info.PersonalInfoViewModel
import com.example.healthhub.util.binding.BindingActivity

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val viewModel: PersonalInfoViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
    }

    private fun initLayout() {
        val personalInfo = viewModel.getUserInfo()
        Log.e("nickname", "${personalInfo.nickname}")
        val welcomeMessage = getString(R.string.home_title, personalInfo.nickname)
        binding.tvWelcomeMessage.text = welcomeMessage
    }
}