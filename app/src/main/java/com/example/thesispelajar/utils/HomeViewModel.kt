package com.example.thesispelajar.utils

import androidx.lifecycle.ViewModel
import com.example.thesispelajar.utils.models.DatumModel

class HomeViewModel : ViewModel() {

    fun getListPrestasiSantri(): List<DatumModel> = DatumDummy.generateDataMovieDummy()
    fun getListPrestasiPengajar(): List<DatumModel> = DatumDummy.generateDataPengajarDummy()

}