package com.example.database.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

class PokemonInfoDataStore @Inject constructor(
    @Named("contentList") private val dataStore: DataStore<Preferences>,
) {

    object PreferencesKey {
        val POKEMON_INFO = stringPreferencesKey("POKEMON_INFO")
        val LAST_UPDATED_DATE = stringPreferencesKey("LAST_UPDATE_DATE")
    }

    /**
     * Json 형식 저장
     */
    suspend fun insertPokemonInfo(contentInfo: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.POKEMON_INFO] = contentInfo
        }
    }

    val pokemonInfo: Flow<String> = dataStore.data.map { preferences ->
        preferences[PreferencesKey.POKEMON_INFO] ?: ""
    }

    /**
     * "yyyyMMdd" 날짜 저장
     */
    suspend fun insertLastUpdatedDate(date: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.LAST_UPDATED_DATE] = date
        }
    }

    val lastUpdatedDate: Flow<String> = dataStore.data.map { preferences ->
        preferences[PreferencesKey.LAST_UPDATED_DATE] ?: ""
    }

    /**
     * 모든 데이터 초기화
     */
    suspend fun clearAllPreferences() {
        dataStore.edit { it.clear() }
    }
}