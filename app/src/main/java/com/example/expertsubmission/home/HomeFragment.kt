package com.example.expertsubmission.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.source.Resource
import com.example.core.ui.AnimalsAdapter
import com.example.expertsubmission.R
import com.example.expertsubmission.databinding.FragmentHomeBinding
import com.example.expertsubmission.detail.DetailActivity
import com.example.expertsubmission.detail.DetailActivity.Companion.EXTRA_DATA
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        if (activity != null) {
            val animalsAdapter = AnimalsAdapter()
            animalsAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(EXTRA_DATA, selectedData)
                startActivity(intent)
            }
            homeViewModel.animal.observe(viewLifecycleOwner, { animals ->
                if (animals != null) {
                    when (animals) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            animalsAdapter.setData(animals.data)
                            Log.e("data", animals.data.toString())
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(
                                context,
                                animals.message ?: "Terjadi kesalahan",
                                Toast.LENGTH_SHORT
                            ).show()
                            Log.e("HomeFragment", "onViewCreated: ${animals.data}")
                            Log.e("HomeFragment", "onViewCreated: ${animals.message}")
                        }
                    }
                }
            })
            with(binding.rvAnimals) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = animalsAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvAnimals.adapter = null
    }
}