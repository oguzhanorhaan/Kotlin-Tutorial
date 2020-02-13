package com.oguzhanorhan.kotlinmqttexample.domain.model

interface  UIHandlerInterface {
    fun resetUIWithConnection(status: Boolean)
    fun updateStatusViewWith(status: String)
    fun update(message: String)
}