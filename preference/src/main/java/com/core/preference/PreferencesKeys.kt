package com.core.preference

import androidx.datastore.preferences.core.stringPreferencesKey

class PreferencesKeys {
    companion object {
        val lang = stringPreferencesKey(name = "lang")
        val token = stringPreferencesKey(name = "token")
        val userName = stringPreferencesKey(name = "userName")
        val password = stringPreferencesKey(name = "password")
    }
}
