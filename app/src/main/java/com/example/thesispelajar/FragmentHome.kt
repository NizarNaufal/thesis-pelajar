package com.example.thesispelajar

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thesispelajar.common.BaseFragment
import com.example.thesispelajar.databinding.FragmentHomeBinding
import com.example.thesispelajar.utils.DatumCallback
import com.example.thesispelajar.utils.HomeViewModel
import com.example.thesispelajar.utils.adapter.DataListSantriAdapter
import com.example.thesispelajar.utils.models.DatumModel

class FragmentHome : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    DatumCallback {

    private lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        let {
            viewModel = ViewModelProvider(
                it,
                ViewModelProvider.NewInstanceFactory()
            )[HomeViewModel::class.java]
        }
        val listMovie = viewModel.getListPrestasiSantri()
        setupRecyclerView(listMovie)

        binding.ivBackgroundPrestasiSantri.setOnClickListener {
            Intent(requireContext(), ActivityListSantri::class.java).apply {
                startActivity(this)
            }
        }
        binding.tvShowAll.setOnClickListener {
            Intent(requireContext(), ActivityListSantri::class.java).apply {
                startActivity(this)
            }
        }
    }
    private fun setupRecyclerView(data: List<DatumModel>) {
        with(binding) {
            rvSantri.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = DataListSantriAdapter(this@FragmentHome)
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
        Intent(requireContext(), ActivityDetailSantri::class.java).apply {
            putExtra("data",data)
            startActivity(this)
        }
    }

}