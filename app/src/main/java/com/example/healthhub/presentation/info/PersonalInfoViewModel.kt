package com.example.healthhub.presentation.info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.healthhub.data.LocalData
import com.example.healthhub.data.PersonalInfo


class PersonalInfoViewModel(private val localData: LocalData) : ViewModel() {

    var nickname = MutableLiveData("")
    var height = MutableLiveData("")
    var weight = MutableLiveData("")

    fun savePersonalInfo() {
        localData.nickname = nickname.value.toString()
        localData.height = height.value?.toInt()!!
        localData.weight = weight.value?.toInt()!!
    }

    fun getUserInfo(): PersonalInfo {
        return PersonalInfo(
            localData.nickname,
            localData.height.toString(),
            localData.weight.toString()
        )
    }
}
