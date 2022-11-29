package com.example.thesispelajar

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thesispelajar.common.BaseActivity
import com.example.thesispelajar.databinding.ActivityPilihSantriBinding
import com.example.thesispelajar.utils.DatumCallback
import com.example.thesispelajar.utils.HomeViewModel
import com.example.thesispelajar.utils.adapter.DataListSantriAdapter
import com.example.thesispelajar.utils.models.DatumModel

class ActivityChangeListSantri : BaseActivity<ActivityPilihSantriBinding>(ActivityPilihSantriBinding::inflate),
    DatumCallback {
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbarVerification)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        let {
            viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            )[HomeViewModel::class.java]
        }
        val listMovie = viewModel.getListPrestasiSantri()
        setupRecyclerView(listMovie)
    }
    private fun setupRecyclerView(data: List<DatumModel>) {
        with(binding) {
            rvListSantri.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = DataListSantriAdapter(this@ActivityChangeListSantri)
            }.also {
                it.adapter.let { adapter ->
                    when (adapter) {
                        is DataListSantriAdapter -> {
                            adapter.setData(data)
                        }
                    }
                }
            }
        }
    }

    override fun onItemClicked(data: DatumModel) {
        binding.btnVerifyConfirm.isEnabled = true
        binding.btnVerifyConfirm.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data", data)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
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