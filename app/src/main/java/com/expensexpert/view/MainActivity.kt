package com.expensexpert.view
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.expensexpert.R
import com.expensexpert.data.Injector
import com.expensexpert.databinding.ActivityMainBinding
import com.expensexpert.viewmodel.WeatherViewModel
import com.expensexpert.viewmodel.WeatherViewModelFactory
import com.google.android.material.navigation.NavigationBarView
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory : WeatherViewModelFactory

    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.toolbar.title = getString(R.string.app_name)
        (application as Injector).createWeatherSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this,factory)
            .get(WeatherViewModel::class.java)

        val data = viewModel.getData()
        data.observe(this, Observer {
            Log.d("Results", it.toString())
        })
         replaceFragment(HomeFragment())

         activityMainBinding.bottomNavigationView.setOnItemSelectedListener { item ->
             val menuItemId = item.itemId
             if (menuItemId == R.id.home) {
                 replaceFragment(HomeFragment())
             } else if (menuItemId == R.id.history) {
                 replaceFragment(HistoryFragment())
             } else if (menuItemId == R.id.profile){
                 replaceFragment(ProfileFragment())
             }
             true
         }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}