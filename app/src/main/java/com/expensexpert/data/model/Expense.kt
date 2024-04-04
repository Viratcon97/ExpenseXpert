package com.expensexpert.data.model

import com.google.gson.annotations.SerializedName

data class Expense(
    @SerializedName("expenseAmount")
    val expenseAmount : String? = null,

    @SerializedName("expenseDescription")
    val expenseDescription : String? = null,

    @SerializedName("expenseTitle")
    val expenseTitle : String? = null,

    @SerializedName("user")
    val user : String? = null
)