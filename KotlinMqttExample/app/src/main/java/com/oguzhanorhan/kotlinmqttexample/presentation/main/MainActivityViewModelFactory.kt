package com.oguzhanorhan.kotlinmqttexample.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oguzhanorhan.kotlinmqttexample.data.repositories.MQTTRepository

@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory(
    private val repository: MQTTRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return MainActivityViewModel(repository) as T
    }
}