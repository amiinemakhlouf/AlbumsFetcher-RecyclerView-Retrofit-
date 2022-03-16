package com.example.retrofitrecyclerview.data.model.services

import com.example.retrofitrecyclerview.data.model.DTO.AlbumDTO
import com.example.retrofitrecyclerview.data.model.DataSource.RetrofitBuilder

object AlbumService {

    val albumService = RetrofitBuilder.build().create(AlbumDTO::class.java)

}