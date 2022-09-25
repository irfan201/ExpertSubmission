package com.example.expertsubmission.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.core.domain.model.Animals
import com.example.expertsubmission.R
import com.example.expertsubmission.databinding.ActivityDetail2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetail2Binding
    private val detailViewModel: DetailViewModel by viewModels()

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Animals>(EXTRA_DATA)
        data?.apply {
            binding.apply {
                tvNamaDetail.text = name
                tvLatinDetail.text = latinName
                tvHabitatDetail.text = habitat
                tvAnimalType.text = animalType
                tvActiveDetail.text = activeTime
                tvGeo.text = geoRange
                Glide.with(this@DetailActivity)
                    .load(imageLink)
                    .into(ivDetail)
                var statusFavorite = isFavorite
                setFavorite(statusFavorite)
                fabFavorite.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailViewModel.setFavoriteAnimal(data, statusFavorite)
                    setFavorite(statusFavorite)
                }
            }
        }
    }

    private fun setFavorite(status: Boolean){
        if (status){
            binding.fabFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            binding.fabFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

}