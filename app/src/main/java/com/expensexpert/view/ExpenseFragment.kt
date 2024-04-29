package com.expensexpert.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.expensexpert.databinding.FragmentExpenseBinding
import com.expensexpert.utils.Constants
import com.expensexpert.viewmodel.AddExpenseViewModel


class ExpenseFragment : Fragment() {

    private lateinit var viewModel: AddExpenseViewModel

    private lateinit var expenseBinding: FragmentExpenseBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        expenseBinding = FragmentExpenseBinding.inflate(layoutInflater)
        return expenseBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(AddExpenseViewModel::class.java)

        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, Constants.dropdownList)

        expenseBinding.dropdownTax.adapter = adapter

        expenseBinding.editTextText2.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                //Perform Tax Calculation
                calculateTax(s.toString())
            }

        })
        expenseBinding.button.setOnClickListener {
            val expenseTitle = expenseBinding.editTextText.text.toString()
            val expenseDescription = expenseBinding.editTextTextMultiLine.text.toString()
            val expenseAmount = expenseBinding.editTextText2.text.toString()

            viewModel.saveExpenseDetails(expenseTitle,expenseDescription,expenseAmount)

        }

        viewModel.responseStatus.observe(viewLifecycleOwner){status ->
            if(status){
                Toast.makeText(requireActivity(),"Expense Successfully Added!",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(requireActivity(),"Please try again!",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun calculateTax(expense: String) {

    }

}