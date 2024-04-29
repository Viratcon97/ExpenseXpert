package com.expensexpert.utils

import com.expensexpert.data.model.TaxCal

class Constants {

    companion object{
        val dropdownList : ArrayList<TaxCal> = arrayListOf(
            TaxCal("Florida (15%)", 15), TaxCal("Texas (13%)", 13),
            TaxCal("Washington (12%)",12))
    }
}