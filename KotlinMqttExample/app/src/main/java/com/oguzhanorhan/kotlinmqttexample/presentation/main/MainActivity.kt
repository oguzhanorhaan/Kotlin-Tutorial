package com.oguzhanorhan.kotlinmqttexample.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.oguzhanorhan.kotlinmqttexample.R
import com.oguzhanorhan.kotlinmqttexample.databinding.ActivityMainBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware{
    override val kodein by kodein()
    private val factory : MainActivityViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding  = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val vm = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)

        binding.mainActivityViewModel = vm
        binding.lifecycleOwner = this
    }
}