package com.expensexpert.data

import android.util.Log
import com.expensexpert.data.model.Expense
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

object FirebaseGetExpenses {

    suspend fun readExpenseData() : Expense{
        var list = Expense()
        val db = Firebase.firestore
        db.collection("expenses")
            .get()
            .addOnSuccessListener { result ->
                for (expense in result.documents){
                    //list  = expense.data.
                }

            }
            .addOnFailureListener {
                Log.d("TAG",""+it)
            }
        Log.d("TAG",""+list)
        return list
    }
}