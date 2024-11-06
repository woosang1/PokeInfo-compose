package com.example.data.repository

import com.example.data.datasource.PokemonInfoLocalDataSource
import com.example.data.datasource.PokemonInfoRemoteDataSource
import com.example.data.mapper.mapperToPokemonInfo
import com.example.data.network.ApiResult
import com.example.domain.model.PokemonInfo
import com.example.domain.repository.PokemonInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonInfoRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonInfoRemoteDataSource,
    private val localDataSource: PokemonInfoLocalDataSource
) : PokemonInfoRepository {

    /** remote **/
    override suspend fun getPokemonInfo(
        limit: Int?,
        offset: Int?,
    ): Flow<List<PokemonInfo>> = flow {
        remoteDataSource.getPokemonInfo().collect { it ->
            when(it){
                is ApiResult.Success -> {
                    emit(it.value.pokemonItems.mapperToPokemonInfo())
                }
                is ApiResult.Error -> {
                    // TODO: Local에서 꺼낼예정
                    /**
                     * 예외처리 생각해봐야함.
                     */
                    emit(ArrayList<PokemonInfo>().toList())
                }
            }
        }
    }

    /** local **/
    override fun insertLocalDB() { localDataSource.insert() }
    override fun clearLocalDB() { localDataSource.clear() }
    override fun deleteLocalDB(id: String) { localDataSource.deleteContent(id) }

}