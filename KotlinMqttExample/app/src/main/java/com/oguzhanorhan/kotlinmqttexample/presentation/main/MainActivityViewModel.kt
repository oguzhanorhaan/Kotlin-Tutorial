package com.oguzhanorhan.kotlinmqttexample.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oguzhanorhan.kotlinmqttexample.data.repositories.MQTTRepository
import com.oguzhanorhan.kotlinmqttexample.domain.model.UIHandlerInterface
import kotlinx.coroutines.*

open class MainActivityViewModel(
    private val mqttRepository: MQTTRepository
) : ViewModel(), UIHandlerInterface{

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main +  viewModelJob)

    private var _messages = MutableLiveData<String>()

    val messages: LiveData<String>
        get() = _messages

    private var _statusText = MutableLiveData<String>()

    val statusText: LiveData<String>
        get() = _statusText

    private var _status = MutableLiveData<Boolean>()

    val status: LiveData<Boolean>
        get() = _status

    init {
        _messages.value = ""
        _statusText.value = ""
        _status.value = false
        resetUIWithConnection(false)
    }

    fun onConnectClicked() {
        uiScope.launch {
            subscribeToMqttBroker()
        }
    }

    private suspend fun subscribeToMqttBroker() {
        withContext(Dispatchers.IO) {
            mqttRepository.connectToBroker(this@MainActivityViewModel)
        }
    }

    override fun resetUIWithConnection(status: Boolean) {
        // Update the status label.
        if (status){
            Log.e("Mqtt", status.toString()+ " reset ui with the connection")
            updateStatusViewWith("Connected")
        }else{
            updateStatusViewWith("Disconnected")
        }
    }

    override fun updateStatusViewWith(status: String) {
        _statusText.value = status
    }

    override fun update(message: String) {
          val newText = """
            ${_messages.value}
            $message
            """
        _messages.value = newText
    }
}