package com.example.netronictesttask.common.util

import android.content.Context
import android.content.SharedPreferences

class PrefsHelper(
    context: Context
) {
    private val PREFS_NAME_KEY = "PREFS_NAME_KEY"

    private val PREFS_IS_DARK_MODE_KEY = "PREFS_IS_DARK_MODE_KEY"
    private val PREFS_IS_RESTORED_KEY = "PREFS_IS_RESTORED_KEY"

    private var mSharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME_KEY, Context.MODE_PRIVATE)

    fun putIsInDarkModeBoolean(bool: Boolean) {
        val editor = mSharedPreferences.edit()
        editor.putBoolean(PREFS_IS_DARK_MODE_KEY, bool)
        editor.apply()
    }

    fun getIsInDarkModeBoolean(): Boolean {
        return mSharedPreferences.getBoolean(PREFS_IS_DARK_MODE_KEY, false)
    }

    fun putIsRestoredBoolean(bool: Boolean) {
        val editor = mSharedPreferences.edit()
        editor.putBoolean(PREFS_IS_RESTORED_KEY, bool)
        editor.apply()
    }

    fun getIsRestoredBoolean(): Boolean {
        return mSharedPreferences.getBoolean(PREFS_IS_RESTORED_KEY, false)
    }
}