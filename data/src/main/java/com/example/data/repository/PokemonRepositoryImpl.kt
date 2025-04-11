package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.datasource.local.PokemonInfoLocalDataSource
import com.example.data.datasource.remote.PokemonRemoteDataSource
import com.example.data.mapper.toEntity
import com.example.database.room.PokemonRoomEntity
import com.example.database.room.toDomain
import com.example.database.room.toEntity
import com.example.model.ui.Pokemon
import com.example.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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
                com.example.data.datasource.remote.PokemonListPagingSource(
                    pokemonRemoteDataSource = remoteDataSource,
                    startPage = page,
                    pagingSize = PAGING_SIZE
                )
            }
        ).flow
    }

    override suspend fun getPokemonInfo(id: Int): Pokemon = remoteDataSource.getPokemonInfo(id).toEntity()
    override suspend fun getPokemonSpeciesInfo(id: Int): Pokemon = remoteDataSource.getPokemonSpeciesInfo(id).toEntity()
    override suspend fun getPokemonTypeInfo(type: String) = remoteDataSource.getPokemonTypeInfo(type).toEntity()

    /** local **/
    override suspend fun getLikePokemonList(): Flow<List<Pokemon>>
        = localDataSource.getPokemonList().map { list -> list.map { it.toDomain() } }
    override suspend fun insertLocalDB(pokemon: Pokemon) { localDataSource.insert(pokemon = pokemon.toEntity()) }
    override suspend fun deleteLocalDB(id: Int) { localDataSource.deleteContent(id) }
    override suspend fun clearLocalDB() { localDataSource.clear() }

}

private const val PAGING_SIZE = 20
