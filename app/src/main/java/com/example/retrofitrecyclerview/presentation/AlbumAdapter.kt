package com.example.retrofitrecyclerview.presentation

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitrecyclerview.data.model.Album
import com.example.retrofitrecyclerview.data.model.services.AlbumService
import com.example.retrofitrecyclerview.databinding.ItemBinding
import com.squareup.picasso.Picasso

class AlbumAdapter(
    var dataSEt: List<Album>
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {
    inner class AlbumViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)
        {

        fun bind(data:Album)
        {
            binding.firstTV.text=data.id.toString()
            binding.secondTV.text=data.title
            Picasso.get().load(data.url).into(binding.image)

        }





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
        val p = dataSEt[position]
        holder.itemView.apply {
            holder.bind(dataSEt[position])

        }
    }


    override fun getItemCount(): Int {
        return dataSEt.size
    }}