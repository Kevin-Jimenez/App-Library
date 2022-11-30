package com.example.applibrary.ui.activities

import android.animation.Animator
//import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
//import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.applibrary.data.datasource.MemoryDatasource
import com.example.applibrary.data.db.AppDatabase
import com.example.applibrary.data.viewmodels.LoginViewModel
import com.example.applibrary.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val db: AppDatabase by inject()
    private val memoryDatasource: MemoryDatasource by inject()
    private val scope = CoroutineScope(newSingleThreadContext("splash"))
    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.splashAnimation.playAnimation()
        scope.launch {
            if(db.servicesDao().getCount() == 0){
                db.servicesDao().insertAll(memoryDatasource.services())
            }
            if(db.libroDao().getCount() == 0){
                db.libroDao().insertAll(memoryDatasource.libros())
            }
        }
        binding.splashAnimation.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(animation: Animator) {

            }

            override fun onAnimationEnd(animation: Animator) {
                loginViewModel.currentUser()
            }

            override fun onAnimationCancel(animation: Animator) {
                TODO("Not yet implemented")
            }

            override fun onAnimationRepeat(animation: Animator) {
                TODO("Not yet implemented")
            }

        })
        observeViewModels()
    }

    private fun observeViewModels(){
        loginViewModel.user.observe(this, Observer {
            if(it != null){
                val intent = Intent(applicationContext, HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(applicationContext, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }

        })
    }

}