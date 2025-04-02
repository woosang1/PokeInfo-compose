package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.datasource.local.PokemonInfoLocalDataSource
import com.example.data.datasource.remote.PokemonListPagingSource
import com.example.data.datasource.remote.PokemonRemoteDataSource
import com.example.data.mapper.toDomain
import com.example.domain.model.Pokemon
import com.example.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val localDataSource: PokemonInfoLocalDataSource,
    private val remoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {

    /** remote **/
    override fun getPokemonList(page: Int): Flow<PagingData<Pokemon>> {
        return Pager(
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
    }

    override suspend fun getPokemonInfo(id: Int): Pokemon = remoteDataSource.getPokemonInfo(id).toDomain()

    override suspend fun getPokemonTypeInfo(type: String) = remoteDataSource.getPokemonTypeInfo(type).toDomain()

    /** local **/
    override fun insertLocalDB() { localDataSource.insert() }
    override fun clearLocalDB() { localDataSource.clear() }
    override fun deleteLocalDB(id: String) { localDataSource.deleteContent(id) }

}

private const val PAGING_SIZE = 20
