package com.example.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.R
import com.example.core.databinding.ItemAnimalsBinding
import com.example.core.domain.model.Animals
class AnimalsAdapter: RecyclerView.Adapter<AnimalsAdapter.listViewHolder>() {

    private val listAnimals = ArrayList<Animals>()
    var onItemClick: ((Animals) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<Animals>?){
        if (newListData == null) return
        listAnimals.clear()
        listAnimals.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animals, parent, false)
        return listViewHolder(view)
    }

    override fun onBindViewHolder(holder: listViewHolder, position: Int) {
        val data = listAnimals[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listAnimals.size

    inner class listViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemAnimalsBinding.bind(itemView)
        fun bind(data: Animals) {
            with(binding) {
                tvNamaHewan.text = data.name
                tvAnimalType.text = data.animalType
                tvLatinName.text = data.latinName
                Glide.with(itemView.context)
                    .load(data.imageLink)
                    .into(ivAnimals)
            }
        }

        init {
            binding.root.setOnClickListener{
                onItemClick?.invoke(listAnimals[adapterPosition])
            }
        }
    }
}