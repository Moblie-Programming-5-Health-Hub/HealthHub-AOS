package com.example.healthhub.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.healthhub.BuildConfig

class LocalData(context: Context) {
    private val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val dataStore: SharedPreferences =
        if (BuildConfig.DEBUG) context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        else EncryptedSharedPreferences.create(
            context,
            FILE_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    var nickname: String
        set(value) = dataStore.edit { putString(USER_NICKNAME, value) }
        get() = dataStore.getString(USER_NICKNAME, "") ?: ""

    var height: Int
        set(value) = dataStore.edit { putInt(USER_HEIGHT, value) }
        get() = dataStore.getInt(USER_HEIGHT, 0)

    var weight: Int
        set(value) = dataStore.edit { putInt(USER_WEIGHT, value) }
        get() = dataStore.getInt(USER_WEIGHT, 0)


    companion object {
        const val FILE_NAME = "HealthHub"
        const val USER_NICKNAME = "nickname"
        const val USER_HEIGHT = "height"
        const val USER_WEIGHT = "weight"
    }
}