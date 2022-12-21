package com.core.preference.shared_preferences

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.core.preference.DataStores
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppDataStore constructor(context: Context, var prefName: String) :
    DataStores {

    private val Context.dataStore by preferencesDataStore(prefName)
    private val dataStore = context.dataStore

    override suspend fun <T> getValue(key: Preferences.Key<T>, defaultValue: T): Flow<T> {
        return dataStore.data.map { pref ->
            pref[key] ?: defaultValue
        }
    }

    override suspend fun <T> saveValue(key: Preferences.Key<T>, value: T) {
        dataStore.edit { pref ->
            pref[key] = value
        }
    }

    override suspend fun clearStore() {
        dataStore.edit { pref ->
            pref.clear()
        }
    }
}