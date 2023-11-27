package com.example.healthhub.presentation.info

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.healthhub.R
import com.example.healthhub.common.ViewModelFactory
import com.example.healthhub.data.LocalData
import com.example.healthhub.databinding.ActivityPersonalInfoBinding
import com.example.healthhub.presentation.water.HydrationActivity
import com.example.healthhub.util.extension.hideKeyboard
import com.example.healthhub.util.binding.BindingActivity

class PersonalInfoActivity :
    BindingActivity<ActivityPersonalInfoBinding>(R.layout.activity_personal_info) {
    private val viewModel: PersonalInfoViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        addListeners()
    }

    private fun addListeners() {
        binding.root.setOnClickListener {
            hideKeyboard(it)
        }
        binding.btnAllReady.setOnClickListener {
            Log.e("button click","${viewModel.nickname.value}")
            viewModel.savePersonalInfo()
            moveToHome()
        }
    }

    private fun moveToHome() {
        Log.e("home click","${viewModel.nickname.value}")
        val intent = Intent(this, HydrationActivity::class.java)
        startActivity(intent)
        finish()
    }
}