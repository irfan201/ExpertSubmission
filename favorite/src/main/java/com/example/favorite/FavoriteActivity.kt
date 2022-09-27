package com.example.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.ui.AnimalsAdapter
import com.example.expertsubmission.detail.DetailActivity
import com.example.expertsubmission.di.FavoriteModuleDepedencies
import com.example.favorite.databinding.ActivityFavoriteBinding
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    @Inject
    lateinit var factory: ViewModelFactory
    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Favorite Animals"

        DaggerFavoriteComponent.builder()
            .context(this)
            .appDepedencies(EntryPointAccessors.fromApplication(this, FavoriteModuleDepedencies::class.java))
            .build().inject(this)

        val animalsAdapter = AnimalsAdapter()

        with(binding.rvFavorite){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = animalsAdapter
        }
        animalsAdapter.onItemClick= {selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA,selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteAnimal.observe(this,{
            if (it.isEmpty()){
                binding.pbFavorite.visibility = View.GONE
                Toast.makeText(this,"data tidak ada", Toast.LENGTH_SHORT).show()
            }else{
                animalsAdapter.setData(it)
                binding.pbFavorite.visibility = View.GONE
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.rvFavorite.adapter = null
    }
}