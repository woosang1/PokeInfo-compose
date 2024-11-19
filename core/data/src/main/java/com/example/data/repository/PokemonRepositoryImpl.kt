package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.datasource.local.PokemonInfoLocalDataSource
import com.example.data.datasource.remote.PokemonListPagingSource
import com.example.data.datasource.remote.PokemonRemoteDataSource
import com.example.data.mapper.toDomain
import com.example.data.network.ApiResult
import com.example.domain.model.Pokemon
import com.example.domain.model.PokemonList
import com.example.domain.model.PokemonType
import com.example.domain.repository.PokemonRepository
import com.example.log.DebugLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val localDataSource: PokemonInfoLocalDataSource,
    private val remoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    /** remote **/
    override fun getPokemonList(page: Int): Flow<PagingData<Pokemon>> = flow {
        emitAll(
            Pager(
                config = PagingConfig(
                    pageSize = PAGING_SIZE,
                    initialLoadSize = PAGING_SIZE,
                    prefetchDistance = PAGING_SIZE
                ),
                pagingSourceFactory = {
                    PokemonListPagingSource(
                        pokemonRemoteDataSource = remoteDataSource,
                        startPage = page,
                        pagingSize =  PAGING_SIZE
                    )
                }
            ).flow
        )
    }

    override suspend fun getPokemonInfo(
        id: Int,
        onError : (String) -> Unit
    ): Flow<Pokemon> = flow {
        try {
            DebugLog("try111")
            remoteDataSource.getPokemonInfo(id).collect { it ->
                DebugLog(it.toString())
                when(it){
                    is ApiResult.Success -> { it.value.collect { emit(it.toDomain()) } }
                    is ApiResult.Error -> { onError.invoke(it.exception.message ?: "") }
                }
            }
        }
        catch(e: Exception){
            onError.invoke(e.message ?: "")
            DebugLog("e : ${e.toString()}")
        }
    }

    override suspend fun getPokemonTypeInfo(
        type: String,
        onError : (String) -> Unit
    ): Flow<PokemonType> = flow {
        try {
            remoteDataSource.getPokemonTypeInfo(type).collect { it ->
                DebugLog(it.toString())
                when(it){
                    is ApiResult.Success -> { it.value.collect { emit(it.toDomain()) } }
                    is ApiResult.Error -> { onError.invoke(it.exception.message ?: "") }
                }
            }
        }
        catch (e: Exception) {
            onError.invoke(e.message ?: "")
            DebugLog("e : ${e.toString()}")
        }

    }

    /** local **/
    override fun insertLocalDB() { localDataSource.insert() }
    override fun clearLocalDB() { localDataSource.clear() }
    override fun deleteLocalDB(id: String) { localDataSource.deleteContent(id) }

}

private const val PAGING_SIZE = 20
