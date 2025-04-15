package com.example.home

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.usecase.GetLikePokemonListUseCase
import com.example.domain.usecase.GetPokemonListUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import io.mockk.mockk
import com.example.testing.rule.MainDispatcherRule
import io.mockk.coEvery
import app.cash.turbine.test
import com.example.domain.repository.PokemonRepository
import com.example.home.common.HomeEvent
import com.example.home.common.HomeUiState
import com.example.model.ui.Pokemon
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue

internal class HomeViewModelTest {
    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val pokemonRepository: PokemonRepository = mockk()
    private lateinit var getPokemonListUseCase: GetPokemonListUseCase
    private val getLikePokemonListUseCase: GetLikePokemonListUseCase = mockk(relaxed = true)
    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp(){
        getPokemonListUseCase = GetPokemonListUseCase(pokemonRepository)
    }

    @Test
    fun `처음 로딩 시 로딩 상태`() = runTest {
        // given
        coEvery { pokemonRepository.getPokemonList(any()) } returns flowOf(PagingData.empty())
        homeViewModel = HomeViewModel(getPokemonListUseCase, getLikePokemonListUseCase)

        // when

        // then
        val stateFlow = homeViewModel.state
        stateFlow.test {
            val first = awaitItem()
            assertTrue(first.homeUiState is HomeUiState.Init)
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `데이터 성공시 Success 상태`() = runTest {
        coEvery { pokemonRepository.getPokemonList(any()) } returns flowOf(PagingData.empty())
        homeViewModel = HomeViewModel(getPokemonListUseCase, getLikePokemonListUseCase)

        // when
        homeViewModel.setEvent(HomeEvent.Init)

        // then
        val stateFlow = homeViewModel.state
        stateFlow.test {
            val first = awaitItem()
            assertTrue(first.homeUiState is HomeUiState.Content)
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun `Paging 에러 발생 시 Error 상태`() = runTest {
        // given
        val errorMessage = "네트워크 에러"
        val exception = Exception(errorMessage)

        val pagingSource = object : PagingSource<Int, Pokemon>() {
            override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
                return LoadResult.Error(exception)
            }

            override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? = null
        }

        coEvery { pokemonRepository.getPokemonList(any()) } returns Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { pagingSource }
        ).flow
        homeViewModel = HomeViewModel(getPokemonListUseCase, getLikePokemonListUseCase)


        // when
        homeViewModel.setEvent(HomeEvent.PagingError(exception))

        // then
        homeViewModel.state.test {
            val state = awaitItem()
            assertTrue(state.homeUiState is HomeUiState.Error)
            cancelAndConsumeRemainingEvents()
        }
    }


}