package com.roman.gardeningjournal.ui.gardenlog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.roman.gardeningjournal.data.Plant
import com.roman.gardeningjournal.databinding.ListItemPlantBinding

class GardenLogAdapter(
    private val listPlant: List<Plant>
) :
    RecyclerView.Adapter<GardenLogAdapter.Holder>() {

    private var itemClickListener: ItemClickListener? = null

    inner class Holder(val binding: ListItemPlantBinding) : ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                itemClickListener?.onItemClick(layoutPosition)
            }
        }
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ListItemPlantBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = listPlant.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.plant = listPlant[position]
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }
}