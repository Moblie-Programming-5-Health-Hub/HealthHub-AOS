package com.example.healthhub.presentation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.healthhub.R
import com.example.healthhub.common.ViewModelFactory
import com.example.healthhub.databinding.ActivityHomeBinding
import com.example.healthhub.presentation.calorie.CalorieActivity
import com.example.healthhub.presentation.info.PersonalInfoViewModel
import com.example.healthhub.presentation.water.HydrationActivity
import com.example.healthhub.presentation.workout.WorkoutDetailActivity
import com.example.healthhub.util.binding.BindingActivity
import com.example.healthhub.util.extension.hideKeyboard

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val viewModel: PersonalInfoViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        addListener()
    }

    private fun initLayout() {
        val personalInfo = viewModel.getUserInfo()
        Log.e("nickname", "${personalInfo.nickname}")
        val welcomeMessage = getString(R.string.home_title, personalInfo.nickname)
        binding.tvWelcomeMessage.text = welcomeMessage
    }

    private fun addListener() {
        with(binding) {
            btnExercise.setOnClickListener {
                moveToWorkout()
            }
            btnWater.setOnClickListener {
                moveToWater()
            }
            btnFood.setOnClickListener {
                moveToCalorie()
            }
        }

        binding.root.setOnClickListener {
            hideKeyboard(it)
        }
    }

    private fun moveToWater() {
        val intent = Intent(this, HydrationActivity::class.java)
        startActivity(intent)
    }

    private fun moveToWorkout() {
        val intent = Intent(this, WorkoutDetailActivity::class.java)
        startActivity(intent)
    }

    private fun moveToCalorie() {
        val intent = Intent(this, CalorieActivity::class.java)
        startActivity(intent)
    }
}