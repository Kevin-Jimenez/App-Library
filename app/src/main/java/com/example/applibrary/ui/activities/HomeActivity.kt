package com.example.applibrary.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.applibrary.R
import com.example.applibrary.data.viewmodels.LoginViewModel
import com.example.applibrary.databinding.ActivityHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val loginViewModel: LoginViewModel by viewModel()

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
        loginViewModel.currentUser()
    }
}