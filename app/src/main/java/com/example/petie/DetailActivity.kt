package com.example.petie

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.petie.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        val artwork = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("artwork_data", ArtWork::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("artwork_data")
        }

        artwork?.let { art ->
            setupUI(art)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun setupUI(art: ArtWork) {
        binding.apply {
            tvDetailTitle.text = art.title
            tvDetailAuthor.text = art.author
            tvDetailDescription.text = art.description

            ivDetailImage.load(art.imageUrl) {
                crossfade(true)
                placeholder(android.R.drawable.ic_menu_gallery)
                error(android.R.drawable.stat_notify_error)
            }
        }
    }
}