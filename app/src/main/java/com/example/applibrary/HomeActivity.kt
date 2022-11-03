package com.example.applibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.applibrary.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.homeToolbar.title=""
        setSupportActionBar(binding.homeToolbar)
    }

    override fun onStart() {
        super.onStart()
        binding.homeToolbar.setOnClickListener {

        }

        val navController = findNavController(R.id.nav_home_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.locationFragment,
            R.id.searchFragment,
            R.id.writersFragment
        ))
        binding.activityHomeMenu.setupWithNavController(navController)
        binding.homeToolbar.setupWithNavController(navController, appBarConfiguration)
    }
}