package com.example.data.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.mapper.toEntity
import com.example.utils.log.DebugLog
import com.example.model.ui.Pokemon
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.awaitAll

internal class PokemonListPagingSource(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource,
    private val startPage: Int,
    private val pagingSize: Int,
) : PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val pageNumber = params.key ?: startPage
            val response = pokemonRemoteDataSource.getPokemonList(
                page = if (pageNumber == startPage) pageNumber else (pageNumber*pagingSize),
                limit = pagingSize
            )
            
            // 병렬로 각 포켓몬의 상세 정보를 가져와서 타입 정보 포함
            val data: List<Pokemon> = coroutineScope {
                response.results.map { pokemonListItem ->
                    async {
                        try {
                            // 포켓몬 ID 추출
                            val pokemonId = pokemonListItem.url.split("/").dropLast(1).last().toIntOrNull() ?: 0
                            
                            // 상세 정보 가져오기
                            val pokemonInfo = pokemonRemoteDataSource.getPokemonInfo(pokemonId)
                            pokemonInfo.toEntity()
                        } catch (e: Exception) {
                            DebugLog("Failed to load pokemon detail for ${pokemonListItem.name}: ${e.message}")
                            // 상세 정보 로드 실패 시 기본 정보만 사용
                            pokemonListItem.toEntity()
                        }
                    }
                }.awaitAll()
            }

            LoadResult.Page(
                data = data,
                prevKey = if (pageNumber == startPage) null else pageNumber - 1,
                nextKey = if (data.isEmpty()) null else pageNumber + 1
            )
        } catch (e: Exception) {
            DebugLog("load - catch ${e.message}")
            LoadResult.Error(e)
        }
    }
}

