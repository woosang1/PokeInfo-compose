//package com.example.data.datasource.remote
//
//import javax.inject.Inject
//
//class SearchPhotoSource @Inject constructor(
//    private val searchService: PokeA
//){
//    suspend fun getSearchPhotos(
//        query: String,
//        page: Int,
//        perPage: Int,
//        orderBy: String,
//        contentFilter: String,
//        color: String,
//        orientation: String
//    ) = searchService.getSearchPhotos(
//        query = query,
//        page = page,
//        perPage = perPage,
//        orderBy = orderBy,
//        contentFilter = contentFilter,
//        color = color,
//        orientation = orientation
//    )
//
//}