package com.example.petie

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = getDummyData()

        val adapter = ArtAdapter(data) { selectedArt ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("artwork_data", selectedArt)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getDummyData(): List<ArtWork> {
        return listOf(
            ArtWork(
                1,
                "Landscape with blue mountain",
                "Qi Baishi",
                "Beijing (place of creation) Dimensions: painting 94.3 x 61.7 cm (height x width) ; along roller 82 cm (length)",
                R.drawable.img1
                ),
            ArtWork(
                2,
                "Immortal Peaches",
                "Qi Baishi",
                "乍到瑤台露氣清/修玆三公便宅士",
                R.drawable.img2
            ),
            ArtWork(
                3,
                "Squirrel and cherries",
                "Qi Baishi",
                "Hanging scroll remounted as album leaf; ink on bark paper. Dimensions: 33 x 39.4 cm",
                R.drawable.img
            ),
            ArtWork(
                id = 4,
                title = "Buddhist Temple in Moutain",
                author = "Li Cheng",
                description = "A serene landscape painting traditionally attributed to Li Cheng of the Five Dynasties–Northern Song period. Buddhist Temple in Mountain portrays a secluded temple nestled amid towering, mist-shrouded peaks.",
                imageUrl = R.drawable.img4
            ),
            ArtWork(
                id = 5,
                title = "狸猫图",
                author = "Qian Xuan",
                description = "A delicate painting attributed to the Yuan-dynasty artist Qian Xuan, 狸猫图 depicts a vigilant spotted cat poised among foliage.",
                imageUrl = R.drawable.img5
            ),
            ArtWork(
                id = 6,
                title = "Haboku sansui",
                author = "Sesshu Toyo",
                description = "A masterwork of Muromachi-period ink painting, Haboku Sansui showcases Sesshū Tōyō’s bold haboku (“broken” or “splashed ink”) style. Using spontaneous brushstrokes, blurred ink washes, and minimal detail, Sesshū evokes mountains, trees, and structures that seem to emerge from mist.",
                imageUrl = R.drawable.img6
            )
        )
    }
}