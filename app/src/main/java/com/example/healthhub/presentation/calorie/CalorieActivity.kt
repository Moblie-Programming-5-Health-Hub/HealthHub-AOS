package com.example.healthhub.presentation.calorie

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.healthhub.R
import com.example.healthhub.common.ViewModelFactory
import com.example.healthhub.databinding.ActivityCalorieDetailBinding
import com.example.healthhub.presentation.info.PersonalInfoViewModel
import com.example.healthhub.util.binding.BindingActivity
import com.example.healthhub.util.extension.hideKeyboard

class CalorieActivity :
    BindingActivity<ActivityCalorieDetailBinding>(R.layout.activity_calorie_detail) {
    private val personalInfoViewModel: PersonalInfoViewModel by viewModels { ViewModelFactory(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListener()
        getNickname()
    }

    private fun addListener() {
        binding.root.setOnClickListener {
            hideKeyboard(it)
        }

        binding.btnCalc.setOnClickListener {
            if (isInputEmpty()) {
                Toast.makeText(this, "칼로리를 모두 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val totalCalories = calcTotalCalories()
                val totalPercent = calcCaloriePercent(totalCalories, 2300)

                binding.tvCalorie.text = totalCalories.toString()
                binding.caloriePercent.text = String.format("%.2f", totalPercent)
            }
        }

    }

    private fun isInputEmpty(): Boolean {
        return binding.etMorning.text.toString().trim().isEmpty() &&
                binding.etLunch.text.toString().trim().isEmpty() &&
                binding.etDinner.text.toString().trim().isEmpty()
    }

    private fun calcTotalCalories(): Int {
        val morning = parseCalorieInput(binding.etMorning.text.toString())
        val lunch = parseCalorieInput(binding.etLunch.text.toString())
        val dinner = parseCalorieInput(binding.etDinner.text.toString())
        return (morning + lunch + dinner)
    }

    private fun parseCalorieInput(input: String): Int {
        return if (input.isNotEmpty()) {
            try {
                Integer.parseInt(input)
            } catch (e: NumberFormatException) {
                0
            }
        } else {
            0
        }
    }

    private fun calcCaloriePercent(totalCalories: Int, recommendedCalories: Int): Float {
        return (totalCalories.toFloat() / recommendedCalories) * 100
    }

    private fun getNickname() {
        val personalInfo = personalInfoViewModel.getUserInfo()
        Log.e("nickname", "${personalInfo.nickname}")
        binding.tvUser.text = personalInfo.nickname
        binding.tvUserTmp.text = personalInfo.nickname
    }
}
