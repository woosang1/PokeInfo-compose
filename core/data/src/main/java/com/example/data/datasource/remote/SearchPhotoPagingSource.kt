package com.example.data.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.mapper.toDomain
import com.example.data.network.ApiResult
import com.example.domain.model.Pokemon
import com.example.domain.model.PokemonList
import com.example.log.DebugLog

internal class PokemonListPagingSource(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource,
    private val startPage: Int,
    private val pagingSize: Int,
) : PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        DebugLog("PokemonListPagingSource - getRefreshKey")
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val pageNumber = params.key ?: startPage
            var loadResult: LoadResult<Int, Pokemon> = LoadResult.Page(emptyList(), null, null)
            pokemonRemoteDataSource.getPokemonList(
                page = if (pageNumber == startPage) pageNumber else (pageNumber*pagingSize),
                limit = pagingSize
            ).collect { response ->
                loadResult = when (response) {
                    is ApiResult.Success -> {
                        LoadResult.Page(
                            data = response.value.results.map { it.toDomain() },
                            prevKey = if (pageNumber == 0) null else pageNumber - 1,
                            nextKey = if (response.value.results.isEmpty()) null else pageNumber + 1
                        )
                    }
                    is ApiResult.Error -> LoadResult.Error(Exception(response.exception.message))
                }
            }
            loadResult
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}

