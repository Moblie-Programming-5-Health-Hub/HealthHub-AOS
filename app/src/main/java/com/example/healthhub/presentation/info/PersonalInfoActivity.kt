package com.example.healthhub.presentation.info

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.healthhub.R
import com.example.healthhub.common.ViewModelFactory
import com.example.healthhub.databinding.ActivityPersonalInfoBinding
import com.example.healthhub.presentation.workout.WorkoutDetailActivity
import com.example.healthhub.util.binding.BindingActivity
import com.example.healthhub.util.extension.hideKeyboard
import com.google.android.material.snackbar.Snackbar

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
            Log.e("완료 버튼 클릭", "${viewModel.nickname.value}")
            Log.e("완료 버튼 클릭","${viewModel.gender.value}")
            if (viewModel.readyToStart()) {
                viewModel.savePersonalInfo()
                moveToHome()
            } else {
                Snackbar.make(binding.root, "모두 입력해주세요.", Snackbar.LENGTH_SHORT).apply {
                    anchorView = binding.btnAllReady
                }.show()
            }
        }
    }

    private fun moveToHome() {
        Log.e("완료 버튼 클릭 후 페이지 이동", "${viewModel.nickname.value}")
        val intent = Intent(this, WorkoutDetailActivity::class.java)
        startActivity(intent)
        finish()
    }
}