package com.expensexpert.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddExpenseViewModel : ViewModel() {

    private val _status = MutableLiveData<Boolean>()
    val responseStatus: LiveData<Boolean> get() = _status

    private val db = Firebase.firestore

    fun saveExpenseDetails(
        expenseTitle: String,
        expenseDescription: String,
        expenseAmount: String
    ) {

        val expense = hashMapOf<String,Any>(
            "user" to "user",
            "expenseTitle" to expenseTitle,
            "expenseDescription" to expenseDescription,
            "expenseAmount" to expenseAmount
        )

        viewModelScope.launch(Dispatchers.IO){
            db.collection("expenses")
                .add(expense)
                .addOnSuccessListener {
                    _status.value = true
                }
                .addOnFailureListener {
                    _status.value = false
                }
        }

    }
}