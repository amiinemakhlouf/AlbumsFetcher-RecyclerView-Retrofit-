package com.example.retrofitrecyclerview.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitrecyclerview.R
import com.example.retrofitrecyclerview.data.model.Album
import com.example.retrofitrecyclerview.data.model.services.AlbumService
import com.example.retrofitrecyclerview.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private  lateinit var  dataSet:List<Album>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        CoroutineScope(Dispatchers.IO).launch{

            val  myData= AlbumService.albumService.getAllAlbums()
            Log.d("debug",myData.body()!![0].albumId.toString())
             dataSet= myData.body()!!
            withContext(Main){
                val adapter =AlbumAdapter(dataSet)
                 initRecyclerView(dataset = dataSet,adapter)
              //   adapter.notifyDataSetChanged()
            }
    }
}
    private fun initRecyclerView(dataset:List<Album>,adapter: AlbumAdapter){

        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter


        }

    }

}