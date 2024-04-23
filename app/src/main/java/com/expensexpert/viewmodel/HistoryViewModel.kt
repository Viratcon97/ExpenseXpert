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
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch


class HistoryViewModel : ViewModel() {

    private val _expenseList = MutableLiveData<MutableList<Expense>>()
    val expenseList : MutableLiveData<MutableList<Expense>> get() =  _expenseList


    fun getData() {
            //val list = FirebaseGetExpenses.readExpenseData()
            //Log.d("MyTag","Inside ViewModel - $list")
            val list = mutableListOf<Expense>()
            val db = Firebase.firestore
            db.collection("expenses")
                .get()
                .addOnSuccessListener { result ->
                    for (expense in result){
                        val data = expense.toObject(Expense::class.java)
                        list.add(data)
                    }
                    for (user in list) {
                        Log.d("MyTag","expenseAmount: ${user.expenseAmount}, expenseTitle: ${user.expenseTitle}," +
                                " expenseDescription: ${user.expenseDescription}")
                    }

                }
                .addOnFailureListener {
                    Log.d("MyTag",""+it)
                }
            Log.d("MyTag","Inside ViewModel - ${list.size}")
            _expenseList.value = list
    }

}