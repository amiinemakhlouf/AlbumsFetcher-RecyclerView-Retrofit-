package com.example.retrofitrecyclerview.presentation

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

class MainActivity : AppCompatActivity(),AlbumAdapter.OnExpenseItemClickListener {
    private lateinit var binding :ActivityMainBinding
    private  lateinit var  dataSet:MutableList<Album>
    private lateinit var adapter:AlbumAdapter
    private lateinit var itemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        CoroutineScope(Dispatchers.IO).launch{

            val  myData= AlbumService.albumService.getAllAlbums()
            Log.d("debug",myData.body()!![0].albumId.toString())
             dataSet= myData.body()!!
            withContext(Main){
                 adapter =AlbumAdapter(dataSet,this@MainActivity)
                adapter.notifyDataSetChanged()
                 initRecyclerView(dataset = dataSet,adapter)
              //   adapter.notifyDataSetChanged()
            }
    }
}
    private fun initRecyclerView(dataset:MutableList<Album>,adapter: AlbumAdapter){

        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
        val simpleCallback = object :
            ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                TODO("Not yet implemented")
            }


            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        // Do something when a user swept left
                        Toast.makeText(this@MainActivity,"hello",Toast.LENGTH_LONG).show()
                        dataset.removeAt(position)
                        adapter.notifyDataSetChanged()
                    }
                    /*ItemTouchHelper.RIGHT -> {
                        // Do something when a user swept right
                    }*/
                }
            }
        }
        itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(binding.rv)


    }

    override fun expenseOnItemClick(position: Int) {

        Toast.makeText(this,"hello+${adapter.dataSEt[position].title}",Toast.LENGTH_LONG).show()
    }

}