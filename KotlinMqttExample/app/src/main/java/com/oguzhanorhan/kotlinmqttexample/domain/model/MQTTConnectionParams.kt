package com.oguzhanorhan.kotlinmqttexample.domain.model

data class MQTTConnectionParams( val clientId:String, val host: String, val topic: String, val username: String, val password: String){
}