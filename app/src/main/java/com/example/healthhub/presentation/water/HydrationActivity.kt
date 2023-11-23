package com.example.healthhub.presentation.water

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.healthhub.R
import com.example.healthhub.common.ViewModelFactory
import com.example.healthhub.databinding.ActivityHydrationBinding
import com.example.healthhub.presentation.info.PersonalInfoViewModel
import com.example.healthhub.util.binding.BindingActivity

class HydrationActivity : BindingActivity<ActivityHydrationBinding>(R.layout.activity_hydration) {
    private val viewModel: PersonalInfoViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        initLayout()
    }

    private fun initLayout() {
        val personalInfo = viewModel.getUserInfo()
        Log.e("nickname", "${personalInfo.nickname}")
        val welcomeMessage = getString(R.string.home_title, personalInfo.nickname)
        binding.tvWelcome.text = welcomeMessage
    }
}