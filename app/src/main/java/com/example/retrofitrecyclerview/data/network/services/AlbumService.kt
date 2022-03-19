package com.example.retrofitrecyclerview.data.services

import com.example.retrofitrecyclerview.data.DTO.AlbumDTO
import com.example.retrofitrecyclerview.data.DataSource.RetrofitBuilder

object AlbumService {

    val albumService = RetrofitBuilder.build().create(AlbumDTO::class.java)

}