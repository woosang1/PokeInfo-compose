package com.example.pokeinfo.main.common;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/example/pokeinfo/main/common/MainUiState;", "", "()V", "Empty", "Error", "Result", "Lcom/example/pokeinfo/main/common/MainUiState$Empty;", "Lcom/example/pokeinfo/main/common/MainUiState$Error;", "Lcom/example/pokeinfo/main/common/MainUiState$Result;", "app_debug"})
public abstract class MainUiState {
    
    private MainUiState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/example/pokeinfo/main/common/MainUiState$Empty;", "Lcom/example/pokeinfo/main/common/MainUiState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Empty extends com.example.pokeinfo.main.common.MainUiState {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.pokeinfo.main.common.MainUiState.Empty INSTANCE = null;
        
        private Empty() {
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/example/pokeinfo/main/common/MainUiState$Error;", "Lcom/example/pokeinfo/main/common/MainUiState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class Error extends com.example.pokeinfo.main.common.MainUiState {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.pokeinfo.main.common.MainUiState.Error INSTANCE = null;
        
        private Error() {
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/pokeinfo/main/common/MainUiState$Result;", "Lcom/example/pokeinfo/main/common/MainUiState;", "pokemonList", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/example/domain/model/PokemonInfo;", "(Lkotlinx/collections/immutable/ImmutableList;)V", "getPokemonList", "()Lkotlinx/collections/immutable/ImmutableList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    @androidx.compose.runtime.Immutable()
    public static final class Result extends com.example.pokeinfo.main.common.MainUiState {
        @org.jetbrains.annotations.NotNull()
        private final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonList = null;
        
        public Result(@org.jetbrains.annotations.NotNull()
        kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonList) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> getPokemonList() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.pokeinfo.main.common.MainUiState.Result copy(@org.jetbrains.annotations.NotNull()
        kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonList) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}