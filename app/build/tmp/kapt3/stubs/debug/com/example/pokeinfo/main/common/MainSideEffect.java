package com.example.pokeinfo.main.common;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/example/pokeinfo/main/common/MainSideEffect;", "Lcom/example/ui/SideEffect;", "()V", "CloseBottomSheet", "ShowAllTypeBottomSheet", "ShowFavoriteBottomSheet", "ShowGenerationsBottomSheet", "ShowSearchBottomSheet", "ShowToast", "StartDetailActivity", "Lcom/example/pokeinfo/main/common/MainSideEffect$CloseBottomSheet;", "Lcom/example/pokeinfo/main/common/MainSideEffect$ShowAllTypeBottomSheet;", "Lcom/example/pokeinfo/main/common/MainSideEffect$ShowFavoriteBottomSheet;", "Lcom/example/pokeinfo/main/common/MainSideEffect$ShowGenerationsBottomSheet;", "Lcom/example/pokeinfo/main/common/MainSideEffect$ShowSearchBottomSheet;", "Lcom/example/pokeinfo/main/common/MainSideEffect$ShowToast;", "Lcom/example/pokeinfo/main/common/MainSideEffect$StartDetailActivity;", "app_debug"})
public abstract class MainSideEffect implements com.example.ui.SideEffect {
    
    private MainSideEffect() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/example/pokeinfo/main/common/MainSideEffect$CloseBottomSheet;", "Lcom/example/pokeinfo/main/common/MainSideEffect;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class CloseBottomSheet extends com.example.pokeinfo.main.common.MainSideEffect {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.pokeinfo.main.common.MainSideEffect.CloseBottomSheet INSTANCE = null;
        
        private CloseBottomSheet() {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/pokeinfo/main/common/MainSideEffect$ShowAllTypeBottomSheet;", "Lcom/example/pokeinfo/main/common/MainSideEffect;", "pokemonInfoList", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/example/domain/model/PokemonInfo;", "(Lkotlinx/collections/immutable/ImmutableList;)V", "getPokemonInfoList", "()Lkotlinx/collections/immutable/ImmutableList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class ShowAllTypeBottomSheet extends com.example.pokeinfo.main.common.MainSideEffect {
        @org.jetbrains.annotations.NotNull()
        private final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonInfoList = null;
        
        public ShowAllTypeBottomSheet(@org.jetbrains.annotations.NotNull()
        kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonInfoList) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> getPokemonInfoList() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.pokeinfo.main.common.MainSideEffect.ShowAllTypeBottomSheet copy(@org.jetbrains.annotations.NotNull()
        kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonInfoList) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/pokeinfo/main/common/MainSideEffect$ShowFavoriteBottomSheet;", "Lcom/example/pokeinfo/main/common/MainSideEffect;", "pokemonInfoList", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/example/domain/model/PokemonInfo;", "(Lkotlinx/collections/immutable/ImmutableList;)V", "getPokemonInfoList", "()Lkotlinx/collections/immutable/ImmutableList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class ShowFavoriteBottomSheet extends com.example.pokeinfo.main.common.MainSideEffect {
        @org.jetbrains.annotations.NotNull()
        private final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonInfoList = null;
        
        public ShowFavoriteBottomSheet(@org.jetbrains.annotations.NotNull()
        kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonInfoList) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> getPokemonInfoList() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.pokeinfo.main.common.MainSideEffect.ShowFavoriteBottomSheet copy(@org.jetbrains.annotations.NotNull()
        kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonInfoList) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/example/pokeinfo/main/common/MainSideEffect$ShowGenerationsBottomSheet;", "Lcom/example/pokeinfo/main/common/MainSideEffect;", "pokemonInfoList", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/example/domain/model/PokemonInfo;", "(Lkotlinx/collections/immutable/ImmutableList;)V", "getPokemonInfoList", "()Lkotlinx/collections/immutable/ImmutableList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class ShowGenerationsBottomSheet extends com.example.pokeinfo.main.common.MainSideEffect {
        @org.jetbrains.annotations.NotNull()
        private final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonInfoList = null;
        
        public ShowGenerationsBottomSheet(@org.jetbrains.annotations.NotNull()
        kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonInfoList) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> getPokemonInfoList() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.pokeinfo.main.common.MainSideEffect.ShowGenerationsBottomSheet copy(@org.jetbrains.annotations.NotNull()
        kotlinx.collections.immutable.ImmutableList<com.example.domain.model.PokemonInfo> pokemonInfoList) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/example/pokeinfo/main/common/MainSideEffect$ShowSearchBottomSheet;", "Lcom/example/pokeinfo/main/common/MainSideEffect;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class ShowSearchBottomSheet extends com.example.pokeinfo.main.common.MainSideEffect {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.pokeinfo.main.common.MainSideEffect.ShowSearchBottomSheet INSTANCE = null;
        
        private ShowSearchBottomSheet() {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/example/pokeinfo/main/common/MainSideEffect$ShowToast;", "Lcom/example/pokeinfo/main/common/MainSideEffect;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class ShowToast extends com.example.pokeinfo.main.common.MainSideEffect {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public ShowToast(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.pokeinfo.main.common.MainSideEffect.ShowToast copy(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/example/pokeinfo/main/common/MainSideEffect$StartDetailActivity;", "Lcom/example/pokeinfo/main/common/MainSideEffect;", "pokemonInfo", "Lcom/example/domain/model/PokemonInfo;", "(Lcom/example/domain/model/PokemonInfo;)V", "getPokemonInfo", "()Lcom/example/domain/model/PokemonInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
    public static final class StartDetailActivity extends com.example.pokeinfo.main.common.MainSideEffect {
        @org.jetbrains.annotations.NotNull()
        private final com.example.domain.model.PokemonInfo pokemonInfo = null;
        
        public StartDetailActivity(@org.jetbrains.annotations.NotNull()
        com.example.domain.model.PokemonInfo pokemonInfo) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.domain.model.PokemonInfo getPokemonInfo() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.domain.model.PokemonInfo component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.pokeinfo.main.common.MainSideEffect.StartDetailActivity copy(@org.jetbrains.annotations.NotNull()
        com.example.domain.model.PokemonInfo pokemonInfo) {
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