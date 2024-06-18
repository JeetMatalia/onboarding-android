package com.example.onb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onBackPressed() {
        // Get the current destination
        val currentFragment = navController.currentDestination?.id

        // Check if the current destination is ViewPagerFragment
        if (currentFragment == R.id.viewPagerFragment || currentFragment == R.id.homeFragment) {
            finishAffinity() // Close the app
        } else {
            super.onBackPressed()
        }
    }
}
