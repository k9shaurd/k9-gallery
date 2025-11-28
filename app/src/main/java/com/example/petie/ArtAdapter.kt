package com.example.petie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.petie.databinding.ItemArtworkBinding

class ArtAdapter(
    private val artList: List<ArtWork>,
    private val onItemClick: (ArtWork) -> Unit
) : RecyclerView.Adapter<ArtAdapter.ArtViewHolder>() {

    inner class ArtViewHolder(val binding: ItemArtworkBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        val binding = ItemArtworkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        val art = artList[position]

        with(holder.binding) {
            tvTitle.text = art.title
            tvAuthor.text = art.author

            ivArtImage.load(art.imageUrl) {
                crossfade(true)
                placeholder(android.R.drawable.ic_menu_gallery)
            }

            root.setOnClickListener {
                onItemClick(art)
            }
        }
    }

    override fun getItemCount() = artList.size
}