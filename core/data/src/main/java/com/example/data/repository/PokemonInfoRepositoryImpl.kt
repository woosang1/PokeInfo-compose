package com.example.data.repository

import com.example.data.datasource.PokemonInfoLocalDataSource
import com.example.data.datasource.PokemonInfoRemoteDataSource
import com.example.data.model.rp.RpPokemonInfo
import com.example.domain.model.PokemonInfo
import com.example.data.model.rp.mapperToPokemonInfo
import com.example.domain.repository.PokemonInfoRepository
import javax.inject.Inject

class PokemonInfoRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonInfoRemoteDataSource,
    private val localDataSource: PokemonInfoLocalDataSource
) : PokemonInfoRepository {

    /** remote **/
    override fun getInfo(
        limit: Int?,
        offset: Int?,
        successCallBack: (List<PokemonInfo>) -> Unit,
        failCallBack: (String) -> Unit
    ) {
        // TODO: Flow callback 구현 해야됨./
        remoteDataSource.getInfo()
//        remoteDataSource.getInfo().subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : DisposableSingleObserver<RpPokemonInfo>() {
//                override fun onSuccess(result: RpPokemonInfo) {
//                    val infoList = result.mapperToPokemonInfo()
//                    successCallBack.invoke(infoList)
//                }
//
//                override fun onError(e: Throwable) {
//                    e.message?.let {
//                        failCallBack.invoke(it)
//                    }
//                }
//            })
    }


    /** local **/
    override fun insertLocalDB() { localDataSource.insert() }
    override fun clearLocalDB() { localDataSource.clear() }
    override fun deleteLocalDB(id: String) { localDataSource.deleteContent(id) }

}