package com.example.healthhub.presentation.info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.healthhub.data.GenderType
import com.example.healthhub.data.LocalData
import com.example.healthhub.data.PersonalInfo


class PersonalInfoViewModel(private val localData: LocalData) : ViewModel() {

    var nickname = MutableLiveData("")
    var height = MutableLiveData("")
    var weight = MutableLiveData("")

    private var _gender = MutableLiveData<GenderType>(null)
    var gender = _gender
    fun savePersonalInfo() {
        localData.nickname = nickname.value.toString()
        localData.height = height.value?.toInt()!!
        localData.weight = weight.value?.toInt()!!
        setGenderType()
    }

    fun setGender(gender: GenderType) {
        _gender.value = gender
    }

    private fun setGenderType(): GenderType {
        return if (_gender.value == GenderType.MALE) {
            localData.male = MALE
            GenderType.MALE
        } else {
            localData.female = FEMALE
            GenderType.FEMALE
        }
    }

    fun readyToStart(): Boolean {
        return !nickname.value.isNullOrBlank()
                && !height.value.isNullOrBlank()
                && !weight.value.isNullOrBlank()
                && _gender.value != null
    }

    fun getUserInfo(): PersonalInfo {
        return PersonalInfo(
            localData.nickname,
            localData.height.toString(),
            localData.weight.toString(),
            setGenderType()
        )
    }

    companion object {
        const val MALE = "male"
        const val FEMALE = "female"
    }
}
