package com.expensexpert.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        savingsCalculationBinding.btnCalculate.setOnClickListener {
            val inHandSalary = savingsCalculationBinding.etInHandSalary.text.toString()
            val percentageSavings = savingsCalculationBinding.etSavingsPercentage.text.toString()


            //Check if it is monthly or biWeekly
            var calculateMonthlySavingsAmount = 0.0
            if(savingsCalculationBinding.rbMonthly.isChecked){
                calculateMonthlySavingsAmount =  (inHandSalary.toDouble() * percentageSavings.toDouble())/100
            }
            if(savingsCalculationBinding.rbBiWeekly.isChecked){
                calculateMonthlySavingsAmount = ((inHandSalary.toDouble() * percentageSavings.toDouble())/100) * 2
            }

            val totalAnnualSavings = calculateMonthlySavingsAmount * 12

            savingsCalculationBinding.txtMonthlySavings.text = calculateMonthlySavingsAmount.toString()
            savingsCalculationBinding.txtAnnualSavings.text = totalAnnualSavings.toString()
        }
    }
}