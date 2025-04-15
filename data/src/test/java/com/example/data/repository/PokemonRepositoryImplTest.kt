package com.example.data.repository

import com.example.data.datasource.local.FakePokemonInfoLocalDataSource
import com.example.data.datasource.remote.FakePokemonRemoteDataSource
import com.example.database.room.toEntity
import com.example.model.ui.Pokemon
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.first

internal class PokemonRepositoryImplTest : BehaviorSpec({

    val fakeRemote = FakePokemonRemoteDataSource()
    val fakeLocal = FakePokemonInfoLocalDataSource()

    val repository = PokemonRepositoryImpl(
        localDataSource = fakeLocal,
        remoteDataSource = fakeRemote,
    )

    Given("로컬에 좋아요 포켓몬이 있다") {
        val pokemon = Pokemon(id = 1, name = "피카츄", url = "url")
        fakeLocal.insert(pokemon.toEntity())

        When("좋아요 포켓몬 리스트를 조회하면") {
            val result = repository.getLikePokemonList().first()

            Then("결과에 피카츄가 포함되어 있다") {
                result shouldContain pokemon
            }
        }
    }

    Given("포켓몬 id로 remote 정보를 요청할 때") {
        When("피카츄를 요청하면") {
            val result = repository.getPokemonInfo(25)

            Then("피카츄 정보가 반환된다") {
                result.name shouldBe "Pikachu"
            }
        }
    }
})
