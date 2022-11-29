package com.example.thesispelajar

import android.R
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thesispelajar.common.BaseActivity
import com.example.thesispelajar.databinding.ActivityPrestasiSantriBinding
import com.example.thesispelajar.utils.DatumCallback
import com.example.thesispelajar.utils.HomeViewModel
import com.example.thesispelajar.utils.adapter.DataAdapter
import com.example.thesispelajar.utils.loadImageWithCache
import com.example.thesispelajar.utils.models.DatumModel

class ActivityPrestasiSantri : BaseActivity<ActivityPrestasiSantriBinding>(ActivityPrestasiSantriBinding::inflate) {

    var list_of_items = arrayOf("Jilid 1", "Jilid 2", "Jilid 3","Jilid 4","Jilid 5","Jilid 6")
    var list_of_items_halaman = arrayOf("Halaman 1", "Halaman 2", "Halaman 3","Halaman 4","Halaman 5","Halaman 6","Halaman 7","Halaman 8","Halaman 9","Halaman 10")

    private val REQUEST_PICK_SANTRI = 101

    lateinit var datumModel: DatumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSpinner()
        setupButtonClick()
        setupUi()
    }
    private fun setupUi(){
        datumModel = intent.getParcelableExtra("data")!!
        binding.tvVehicleType.text = datumModel.name
        binding.ivIconDriver.loadImageWithCache(datumModel.img_preview)
        binding.tvManufactureYears.text = datumModel.desc
        binding.btnVerifyConfirm.setOnClickListener {
            showDialog()
        }
        binding.ivChangeSantri.setOnClickListener {
            val intent = Intent(this, ActivityChangeListSantri::class.java)
            startActivityForResult(intent, REQUEST_PICK_SANTRI)
        }
    }
    private fun setupButtonClick(){
        binding.clUlang.setOnClickListener {
            binding.clUlang.setBackgroundResource(com.example.thesispelajar.R.drawable.bg_border_radius_green)
            binding.clNaik.setBackgroundResource(com.example.thesispelajar.R.drawable.bg_border_radius)
        }
        binding.clNaik.setOnClickListener {
            binding.clUlang.setBackgroundResource(com.example.thesispelajar.R.drawable.bg_border_radius)
            binding.clNaik.setBackgroundResource(com.example.thesispelajar.R.drawable.bg_border_radius_green)
        }
    }
    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(com.example.thesispelajar.R.layout.dialog_success_add_pengajar)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val dialogBtn = dialog.findViewById<TextView>(com.example.thesispelajar.R.id.tvOk)
        dialogBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
    private fun setupSpinner(){
        val aa = ArrayAdapter(this, R.layout.simple_spinner_item, list_of_items)
        aa.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        val bb = ArrayAdapter(this, R.layout.simple_spinner_item, list_of_items_halaman)
        bb.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = aa
        binding.spinnerHalaman.adapter = bb
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_PICK_SANTRI -> {
                if (resultCode == Activity.RESULT_OK) {
                    val result: DatumModel? = data?.getParcelableExtra("data")
                    result?.let { onPickUpSantriResult(it) }
                }

            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun onPickUpSantriResult(data: DatumModel){
        binding.tvVehicleType.text = data.name
        binding.ivIconDriver.loadImageWithCache(data.img_preview)
        binding.tvManufactureYears.text = datumModel.desc
    }
}