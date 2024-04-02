package com.expensexpert.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class HomeViewModel : ViewModel() {

    var title = MutableLiveData<String>()

    fun saveExpenseDetails(
        expenseTitle: String,
        expenseDescription: String,
        expenseAmount: String
    ) {

    }
}