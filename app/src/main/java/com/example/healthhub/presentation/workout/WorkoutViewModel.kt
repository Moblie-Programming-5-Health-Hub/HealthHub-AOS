package com.example.healthhub.presentation.workout

import androidx.lifecycle.ViewModel
import com.example.healthhub.R
import com.example.healthhub.data.Workout

class WorkoutViewModel : ViewModel() {
    val workoutList = listOf(
        Workout(R.drawable.workout1,"팔굽혀 펴기 10회"),
        Workout(R.drawable.workout2,"스쿼트 50회"),
        Workout(R.drawable.workout1,"높이 무릎 들기 20회"),
        Workout(R.drawable.workout2,"플랭크 30초"),
        Workout(R.drawable.workout1,"윗몸 일으키기 30회"),
        Workout(R.drawable.workout2,"사이드 플랭크 60초"),
        Workout(R.drawable.workout1,"레그 레이즈 20회"),
        Workout(R.drawable.workout2,"런지 25회"),
        Workout(R.drawable.workout1,"사이드 런지 25회"),
        Workout(R.drawable.workout2,"아령 숄더 프레스 13회"),
        Workout(R.drawable.workout1,"아령 데드리프트 13회"),
        Workout(R.drawable.workout2,"아령 런지 13회"),
        Workout(R.drawable.workout1,"아령 푸쉬 프레스 12회"),
        Workout(R.drawable.workout2,"레그 라이즈 15회"),
        Workout(R.drawable.workout1,"스텝 업 20회")
    )
}