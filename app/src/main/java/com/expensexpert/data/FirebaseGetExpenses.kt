package com.expensexpert.data

import android.util.Log
import com.expensexpert.data.model.Expense
import com.google.firebase.Firebase
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.firestore

class FirebaseGetExpenses {

    companion object{
        suspend fun readExpenseData() : MutableList<Expense>{
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

            return list
        }
    }
}