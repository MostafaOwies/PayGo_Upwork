package com.core.preference

import android.content.Context
import android.content.SharedPreferences
import com.core.utils.constants.SharedPreferenceKeys
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferenceHelper @Inject constructor(@ApplicationContext context: Context) {
    val prefs: SharedPreferences =
        context.getSharedPreferences(SharedPreferenceKeys.PREFS_NAME, Context.MODE_PRIVATE)

    private inline fun edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = prefs.edit()
        operation(editor)
        editor.apply()
    }

    /**
     * puts a value for the given [key].
     */
    operator fun set(key: String, value: Any?) = when (value) {
        is String? -> edit { it.putString(key, value) }
        is Int -> edit { it.putInt(key, value) }
        is Boolean -> edit { it.putBoolean(key, value) }
        is Float -> edit { it.putFloat(key, value) }
        is Long -> edit { it.putLong(key, value) }
        else -> throw UnsupportedOperationException("Not yet implemented")
    }

    /**
     * finds a preference based on the given [key].
     * [T] is the type of value
     * @param defaultValue optional defaultValue - will take a default defaultValue if it is not specified
     */
    inline operator fun <reified T : Any> get(
        key: String,
        defaultValue: T? = null
    ): T = when (T::class) {
        String::class -> prefs.getString(key, defaultValue as? String ?: "") as T
        Int::class -> prefs.getInt(key, defaultValue as? Int ?: -1) as T
        Boolean::class -> prefs.getBoolean(key, defaultValue as? Boolean ?: false) as T
        Float::class -> prefs.getFloat(key, defaultValue as? Float ?: -1f) as T
        Long::class -> prefs.getLong(key, defaultValue as? Long ?: -1) as T
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}