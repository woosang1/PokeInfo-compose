package com.example.data.repository

import com.example.data.datasource.PokemonInfoLocalDataSource
import com.example.data.datasource.PokemonListRemoteDataSource
import com.example.data.mapper.toDomain
import com.example.data.network.ApiResult
import com.example.domain.model.PokemonList
import com.example.domain.repository.PokemonInfoRepository
import com.example.log.DebugLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonListRemoteDataSource,
    private val localDataSource: PokemonInfoLocalDataSource
) : PokemonInfoRepository {

    /** remote **/
    override suspend fun getPokemonInfo(
        limit: Int,
        offset: Int,
        onError: (String) -> Unit,
    ): Flow<PokemonList> = flow {
        remoteDataSource.getPokemonList().collect { it ->
            DebugLog(it.toString())
            when(it){
                is ApiResult.Success -> {
                    emit(it.value.toDomain())
                }
                is ApiResult.Error -> {
                    onError.invoke(it.exception.message ?: "")
                }
            }
        }
    }

    /** local **/
    override fun insertLocalDB() { localDataSource.insert() }
    override fun clearLocalDB() { localDataSource.clear() }
    override fun deleteLocalDB(id: String) { localDataSource.deleteContent(id) }

}