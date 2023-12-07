package com.example.healthhub.presentation.workout

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.healthhub.R
import com.example.healthhub.common.ViewModelFactory
import com.example.healthhub.databinding.ActivityWorkoutDetailBinding
import com.example.healthhub.presentation.info.PersonalInfoViewModel
import com.example.healthhub.util.binding.BindingActivity

class WorkoutDetailActivity :
    BindingActivity<ActivityWorkoutDetailBinding>(R.layout.activity_workout_detail) {
    private val personalInfoViewModel: PersonalInfoViewModel by viewModels { ViewModelFactory(this) }
    private val workoutViewModel: WorkoutViewModel by viewModels()
    private var workoutAdapter= WorkoutAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = personalInfoViewModel
        binding.lifecycleOwner = this

        initLayout()
        collectData()
    }

    private fun initLayout() {
        val personalInfo = personalInfoViewModel.getUserInfo()
        Log.e("nickname", "${personalInfo.nickname}")
        val welcomeMessage = getString(R.string.home_title, personalInfo.nickname)
        binding.tvWelcome.text = welcomeMessage
        binding.rvWorkout.adapter = workoutAdapter
    }

    private fun collectData() {
        val workoutData = workoutViewModel.workoutList
        workoutAdapter.submitList(workoutData)
    }
}