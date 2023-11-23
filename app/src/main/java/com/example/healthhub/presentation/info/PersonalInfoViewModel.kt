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

    fun readyToStart(){
        if(!nickname.value.isNullOrBlank()&&!height.value.isNullOrBlank()&&!weight.value.isNullOrBlank()){
            //TODO 버튼 조건 만족 안할 때 다이얼로그 띄우기
        }
    }
    fun getUserInfo(): PersonalInfo {
        return PersonalInfo(
            localData.nickname,
            localData.height.toString(),
            localData.weight.toString()
        )
    }
}
