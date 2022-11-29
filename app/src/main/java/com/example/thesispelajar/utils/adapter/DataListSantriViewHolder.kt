package com.example.thesispelajar.utils.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.thesispelajar.databinding.ItemListSantriBinding
import com.example.thesispelajar.utils.loadImageWithCache
import com.example.thesispelajar.utils.models.DatumModel

class DataListSantriViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemListSantriBinding.bind(itemView)


    @SuppressLint("SetTextI18n")
    fun bindTo(data: DatumModel) {
        with(binding) {
            itemView.apply {
                ivIconDriver.loadImageWithCache(data.img_preview)
                tvVehicleType.text = data.name
                tvManufactureYears.text = data.desc
            }
        }
    }
}