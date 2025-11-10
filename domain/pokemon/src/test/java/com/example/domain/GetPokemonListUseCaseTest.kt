package com.example.domain

import androidx.paging.AsyncPagingDataDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListUpdateCallback
import com.example.domain.usecase.GetPokemonListUseCase
import com.example.domain.usecase.GetPokemonListUseCaseImpl
import com.example.model.ui.Pokemon
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.UnconfinedTestDispatcher

@OptIn(ExperimentalCoroutinesApi::class)
internal class GetPokemonListUseCaseTest : BehaviorSpec({

    val fakeRepository = FakePokemonRepository()
    val useCase: GetPokemonListUseCase = GetPokemonListUseCaseImpl(fakeRepository)
    val testDispatcher = UnconfinedTestDispatcher()

    Given("포켓몬 리스트를 요청할 때") {
        When("첫 번째 페이지를 요청하면") {
            Then("포켓몬 리스트가 PagingData 형태로 반환된다") {
                kotlinx.coroutines.test.runTest(testDispatcher) {
                    val pagingData = useCase(page = 0).first()

                    val differ = createPagingDataDiffer(dispatcher = testDispatcher)
                    differ.submitData(pagingData)

                    advanceUntilIdle()

                    differ.snapshot().size shouldBe 2
                    differ.snapshot()[0]?.name shouldBe "피카츄"
                    differ.snapshot()[1]?.name shouldBe "이상해씨"
                }
            }
        }
    }
})


private fun createPagingDataDiffer(
    dispatcher: TestDispatcher
): AsyncPagingDataDiffer<Pokemon> {
    return AsyncPagingDataDiffer(
        diffCallback = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return oldItem.thumbnailUrl == newItem.thumbnailUrl
            }

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return oldItem == newItem
            }
        },
        updateCallback = NoopListCallback(),
        mainDispatcher = dispatcher,
        workerDispatcher = dispatcher
    )
}

private class NoopListCallback : ListUpdateCallback {
    override fun onInserted(position: Int, count: Int) {}
    override fun onRemoved(position: Int, count: Int) {}
    override fun onMoved(fromPosition: Int, toPosition: Int) {}
    override fun onChanged(position: Int, count: Int, payload: Any?) {}
}