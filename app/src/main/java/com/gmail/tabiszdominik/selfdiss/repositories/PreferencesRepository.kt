package com.gmail.tabiszdominik.selfdiss.repositories

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Dominik Tabisz on 2019-09-28.
 * tabiszdominik@gmail.com
 */
class PreferencesRepository(preferences: SharedPreferences) {

    var useVulgarInsults: Boolean by BooleanPreference(preferences, "useVulgarInsults")

    class BooleanPreference(
        private val preferences: SharedPreferences,
        private val key: String
    ) : ReadWriteProperty<Any, Boolean> {
        override fun getValue(thisRef: Any, property: KProperty<*>): Boolean = preferences.getBoolean(key, false)
        override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) =
            preferences.edit().putBoolean(key, value).apply()
    }
}