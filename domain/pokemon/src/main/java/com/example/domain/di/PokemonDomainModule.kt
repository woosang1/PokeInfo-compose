package com.example.domain.di

import com.example.domain.usecase.ClearPokemonUseCase
import com.example.domain.usecase.ClearPokemonUseCaseImpl
import com.example.domain.usecase.DeletePokemonUseCase
import com.example.domain.usecase.DeletePokemonUseCaseImpl
import com.example.domain.usecase.GetLikePokemonListUseCase
import com.example.domain.usecase.GetLikePokemonListUseCaseImpl
import com.example.domain.usecase.GetPokemonDetailInfoUseCase
import com.example.domain.usecase.GetPokemonDetailInfoUseCaseImpl
import com.example.domain.usecase.GetPokemonListUseCase
import com.example.domain.usecase.GetPokemonListUseCaseImpl
import com.example.domain.usecase.InsertPokemonUseCase
import com.example.domain.usecase.InsertPokemonUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class PokemonDomainModule {

    @Binds
    abstract fun bindGetPokemonListUseCase(
        impl: GetPokemonListUseCaseImpl
    ): GetPokemonListUseCase

    @Binds
    abstract fun bindGetPokemonDetailInfoUseCase(
        impl: GetPokemonDetailInfoUseCaseImpl
    ): GetPokemonDetailInfoUseCase

    @Binds
    abstract fun bindGetLikePokemonListUseCase(
        impl: GetLikePokemonListUseCaseImpl
    ): GetLikePokemonListUseCase

    @Binds
    abstract fun bindInsertPokemonUseCase(
        impl: InsertPokemonUseCaseImpl
    ): InsertPokemonUseCase

    @Binds
    abstract fun bindDeletePokemonUseCase(
        impl: DeletePokemonUseCaseImpl
    ): DeletePokemonUseCase

    @Binds
    abstract fun bindClearPokemonUseCase(
        impl: ClearPokemonUseCaseImpl
    ): ClearPokemonUseCase
}
