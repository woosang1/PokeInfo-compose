package com.example.data.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.mapper.toDomain
import com.example.network.ApiResult

internal class PokemonListPagingSource(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource,
    private val startPage: Int,
    private val pagingSize: Int,
) : PagingSource<Int, com.example.domain.model.Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, com.example.domain.model.Pokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, com.example.domain.model.Pokemon> {
        return try {
            val pageNumber = params.key ?: startPage
            var loadResult: LoadResult<Int, com.example.domain.model.Pokemon> = LoadResult.Page(emptyList(), null, null)
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

