package com.example.healthhub.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.healthhub.data.LocalData
import com.example.healthhub.presentation.info.PersonalInfoViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonalInfoViewModel::class.java)) {
            return PersonalInfoViewModel(LocalData(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}