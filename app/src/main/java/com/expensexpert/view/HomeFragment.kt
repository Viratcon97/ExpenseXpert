package com.expensexpert.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.expensexpert.databinding.FragmentHomeBinding
import com.expensexpert.utils.Constants
import com.expensexpert.viewmodel.AddExpenseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var viewModel: AddExpenseViewModel

    private lateinit var homeBinding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(AddExpenseViewModel::class.java)

        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, Constants.dropdownList)

        homeBinding.dropdownTax.adapter = adapter

        homeBinding.button.setOnClickListener {
            val expenseTitle = homeBinding.editTextText.text.toString()
            val expenseDescription = homeBinding.editTextTextMultiLine.text.toString()
            val expenseAmount = homeBinding.editTextText2.text.toString()

            CoroutineScope(Dispatchers.Main).launch {
            }
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

}