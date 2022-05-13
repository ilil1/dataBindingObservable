package com.project.databindingobservable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.project.databindingobservable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.activity = this@MainActivity
        setObservable()
    }

    fun setObservable() {
        var user : User = User()
        binding.user = user
        user.firstName = "Test"
        user.lastName = "User"

        Handler().postDelayed(Runnable {
            run {
                user.firstName = "Test modify"
                user.lastName = "User modify"
            }
        },5000)
    }
}