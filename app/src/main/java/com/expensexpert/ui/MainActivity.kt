package com.expensexpert.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.expensexpert.R
import com.google.android.material.navigation.NavigationBarView
import com.expensexpert.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        replaceFragment()

        activityMainBinding.bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            val menuItemId = item.itemId
            if(menuItemId == R.id.home){

            }
            true
        })
    }

    private fun replaceFragment() {

    }
}