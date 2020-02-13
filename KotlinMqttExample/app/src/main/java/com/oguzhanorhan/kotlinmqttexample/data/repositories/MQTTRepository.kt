package com.oguzhanorhan.kotlinmqttexample.data.repositories


import com.oguzhanorhan.kotlinmqttexample.domain.MQTTmanager
import com.oguzhanorhan.kotlinmqttexample.domain.model.UIHandlerInterface

class MQTTRepository (
    private val mqttManager : MQTTmanager) {

    fun connectToBroker(uiUpdater : UIHandlerInterface) {
        mqttManager.uiUpdater = uiUpdater
        mqttManager.connect()
    }
}