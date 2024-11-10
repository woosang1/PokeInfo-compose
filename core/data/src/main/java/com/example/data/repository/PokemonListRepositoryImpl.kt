package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.datasource.local.PokemonInfoLocalDataSource
import com.example.data.datasource.remote.PokemonListPagingSource
import com.example.data.datasource.remote.PokemonListRemoteDataSource
import com.example.domain.model.PokemonList
import com.example.domain.repository.PokemonInfoRepository
import com.example.log.DebugLog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val pokemonListRemoteDataSource: PokemonListRemoteDataSource,
    private val localDataSource: PokemonInfoLocalDataSource
) : PokemonInfoRepository {

    /** remote **/
    override fun getPokemonList(page: Int): Flow<PagingData<PokemonList.Pokemon>> = flow {
        DebugLog("PokemonListRepositoryImpl - getPokemonList [${page}]")
        emitAll(
            Pager(
                config = PagingConfig(
                    pageSize = PAGING_SIZE,
                    initialLoadSize = PAGING_SIZE,
                    prefetchDistance = PAGING_SIZE
                ),
                pagingSourceFactory = {
                    PokemonListPagingSource(
                        pokemonListRemoteDataSource = pokemonListRemoteDataSource,
                        pagingSize =  PAGING_SIZE
                    )
                }
            ).flow
        )
    }

    /** local **/
    override fun insertLocalDB() { localDataSource.insert() }
    override fun clearLocalDB() { localDataSource.clear() }
    override fun deleteLocalDB(id: String) { localDataSource.deleteContent(id) }

}

private const val PAGING_SIZE = 20
