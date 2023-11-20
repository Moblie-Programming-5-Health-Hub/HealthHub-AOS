package com.example.healthhub.presentation.info

import android.os.Bundle
import com.example.healthhub.R
import com.example.healthhub.databinding.ActivityPersonalInfoBinding
import com.example.healthhub.util.binding.BindingActivity
import com.example.healthhub.util.extension.hideKeyboard

class PersonalInfoActivity: BindingActivity<ActivityPersonalInfoBinding>(R.layout.activity_personal_info) {
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