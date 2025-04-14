package com.example.data.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.mapper.toEntity
import com.example.log.DebugLog
import com.example.model.ui.Pokemon

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
            val data = response.results.map { it.toEntity() }

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

