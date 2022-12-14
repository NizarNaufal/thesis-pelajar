package com.example.thesispelajar

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.widget.TextView
import com.example.thesispelajar.common.BaseActivity
import com.example.thesispelajar.databinding.ActivityEditPengajarBinding

class ActivityEditPengajar: BaseActivity<ActivityEditPengajarBinding>(ActivityEditPengajarBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbarVerification)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        binding.btnVerifyConfirm.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_success_add_pengajar)
        dialog.findViewById<TextView>(R.id.tvPopupDescription).text = "Berhasil mengubah data Pengajar "
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val dialogBtn = dialog.findViewById<TextView>(R.id.tvOk)
        dialogBtn.setOnClickListener {
            dialog.dismiss()
            Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(this)
            }
        }
        dialog.show()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                onBackPressed()
                true
            }
            else ->{
                super.onOptionsItemSelected(item)
            }
        }
    }
}