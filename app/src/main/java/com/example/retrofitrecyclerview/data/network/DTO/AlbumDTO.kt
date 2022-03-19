package com.example.retrofitrecyclerview.data.DTO

import com.example.retrofitrecyclerview.data.Album
import retrofit2.Response
import retrofit2.http.GET

interface AlbumDTO {

    @GET(".")
     suspend fun getAllAlbums(): Response<MutableList<Album>>
}