package com.example.retrofitrecyclerview.presentation

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitrecyclerview.data.model.Album
import com.example.retrofitrecyclerview.data.model.services.AlbumService
import com.example.retrofitrecyclerview.databinding.ItemBinding
import com.squareup.picasso.Picasso

class AlbumAdapter(
    var dataSEt: MutableList<Album>,val listener:MainActivity
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    inner class AlbumViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) ,View.OnClickListener {
        init {
            binding.image.setOnClickListener(this)
        }






        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION)
                listener.expenseOnItemClick(position)
        }
    }
    interface OnExpenseItemClickListener{
        fun expenseOnItemClick(position:Int)
    }









    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {


        return AlbumViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = dataSEt[position]
            holder.binding.apply {
                firstTV.text = album.id.toString()
                secondTV.text = album.title
                Picasso.get().load(album.url).into(image)

            }




    }


    override fun getItemCount(): Int {
        return dataSEt.size
    }


  }
