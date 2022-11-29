package com.example.thesispelajar.utils

import com.example.thesispelajar.utils.models.DatumModel


interface DatumCallback  {
    fun onItemClicked(data: DatumModel)
}