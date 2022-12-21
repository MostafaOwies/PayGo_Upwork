package com.core.preference.sharedPref

import android.content.Context
import android.content.SharedPreferences
import com.core.preference.PreferencesKeys.Companion.lang
import com.core.preference.PreferencesKeys.Companion.password
import com.core.preference.PreferencesKeys.Companion.token
import com.core.preference.PreferencesKeys.Companion.userName

class SharedPref constructor(context: Context, var prefName: String) {

    private val mPrefs: SharedPreferences =
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    fun getLang(): String {
        return mPrefs.getString(lang.name, "en")!!
    }

    fun saveLang(value: String) {
        mPrefs.edit().putString(lang.name, value).apply()
    }

    fun getToken(): String {
        return mPrefs.getString(token.name, "")!!
    }

    fun saveToken(value: String) {
        mPrefs.edit().putString(token.name, value).apply()
    }

    fun getUserName(): String {
        return mPrefs.getString(userName.name, "") ?: ""
    }

    fun saveUserName(value: String) {
        mPrefs.edit().putString(userName.name, value).apply()
    }

    fun getPassword(): String {
        return mPrefs.getString(password.name, "") ?: ""
    }

    fun savePassword(value: String) {
        mPrefs.edit().putString(password.name, value).apply()
    }
}