package com.expensexpert.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.expensexpert.data.FirebaseGetExpenses
import com.expensexpert.data.model.Expense
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HistoryViewModel : ViewModel() {

    private val _expenseList = MutableLiveData<Expense>()
    val expenseList : LiveData<Expense> get() =  _expenseList

    fun getData(){
        viewModelScope.launch {
            _expenseList.value = FirebaseGetExpenses.readExpenseData()
        }
    }

}