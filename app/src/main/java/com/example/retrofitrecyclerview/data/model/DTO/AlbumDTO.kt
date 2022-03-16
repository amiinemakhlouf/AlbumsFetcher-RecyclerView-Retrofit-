package com.example.retrofitrecyclerview.data.model.DTO

import com.example.retrofitrecyclerview.data.model.Album
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface AlbumDTO {

    @GET(".")
     suspend fun getAllAlbums(): Response<List<Album>>
}