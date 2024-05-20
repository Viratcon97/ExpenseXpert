package com.expensexpert.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.expensexpert.R
import com.expensexpert.databinding.FragmentHistoryBinding
import com.expensexpert.databinding.FragmentSavingsCalculationBinding
import com.expensexpert.viewmodel.HistoryViewModel


class SavingsCalculationFragment : Fragment() {

    private lateinit var savingsCalculationBinding: FragmentSavingsCalculationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        savingsCalculationBinding = FragmentSavingsCalculationBinding.inflate(layoutInflater)
        return savingsCalculationBinding.root
    }
}