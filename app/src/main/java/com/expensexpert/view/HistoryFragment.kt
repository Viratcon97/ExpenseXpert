package com.expensexpert.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.expensexpert.databinding.FragmentHistoryBinding
import com.expensexpert.viewmodel.HistoryViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryFragment : Fragment() {

    private lateinit var historyBinding: FragmentHistoryBinding
    private lateinit var viewModel: HistoryViewModel

    private var count = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        historyBinding = FragmentHistoryBinding.inflate(layoutInflater)
        return historyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)


        viewModel.getData()

        viewModel.expenseList.observe(requireActivity(), Observer {
            Log.d("MyTag","Inside Fragment - $it")
            historyBinding.text.text = it.toString()
        })

        historyBinding.button1.setOnClickListener {
            //Button Click
            historyBinding.text.text =  count++.toString()
        }
        historyBinding.button2.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch{
                downloadData()
            }
        }
    }

    private suspend fun downloadData() {
        for (i in 1..2000){
            withContext(Dispatchers.Main){
                historyBinding.text.text = "i - $i in ${Thread.currentThread().name}"
            }
        }
    }

}