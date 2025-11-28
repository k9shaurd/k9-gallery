package com.example.petie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtWork(
    val id: Int,
    val title: String,
    val author: String,
    val description: String,
    val imageUrl: Int
) : Parcelable