package com.example.healthhub.presentation.water

import android.os.Bundle
import com.example.healthhub.R
import com.example.healthhub.databinding.ActivityWatercheckBinding
import com.example.healthhub.util.binding.BindingActivity
import com.example.healthhub.util.extension.hideKeyboard

class HydrationActivity:BindingActivity<ActivityWatercheckBinding>(R.layout.activity_watercheck) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
    }

    private fun addListeners(){
        binding.root.setOnClickListener{
            hideKeyboard(it)
        }
    }
}