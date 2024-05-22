package com.expensexpert.view
import android.os.Bundle
import android.util.Log
import android.view.View
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
import github.com.st235.lib_expandablebottombar.MenuItem
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

        //activityMainBinding.toolbar.title = getString(R.string.app_name)
        (application as Injector).createWeatherSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this,factory)
            .get(WeatherViewModel::class.java)

        val data = viewModel.getData()
        data.observe(this, Observer {
            Log.d("Results", it.toString())
        })
         replaceFragment(ExpenseFragment())

         /*activityMainBinding.bottomNavigationView.setOnItemSelectedListener { item ->
             val menuItemId = item.itemId
             if (menuItemId == R.id.home) {
                 replaceFragment(ExpenseFragment())
             } else if (menuItemId == R.id.history) {
                 replaceFragment(HistoryFragment())
             } else if (menuItemId == R.id.profile){
                 replaceFragment(ProfileFragment())
             } else if (menuItemId == R.id.savingsCal){
                 replaceFragment(SavingsCalculationFragment())
             }
             true
         }*/
        activityMainBinding.expandableBottomBar.onItemSelectedListener = { view: View, item: MenuItem, b: Boolean ->
            val menuItemId = item.id
            if (menuItemId == R.id.home) {
                replaceFragment(ExpenseFragment())
            } else if (menuItemId == R.id.history) {
                replaceFragment(HistoryFragment())
            } else if (menuItemId == R.id.profile){
                replaceFragment(ProfileFragment())
            } else if (menuItemId == R.id.savingsCal){
                replaceFragment(SavingsCalculationFragment())
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}