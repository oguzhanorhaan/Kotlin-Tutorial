package com.oguzhanorhan.kotlinmqttexample

import android.app.Application
import com.oguzhanorhan.kotlinmqttexample.data.repositories.MQTTRepository
import com.oguzhanorhan.kotlinmqttexample.domain.MQTTmanager
import com.oguzhanorhan.kotlinmqttexample.domain.model.MQTTConnectionParams
import com.oguzhanorhan.kotlinmqttexample.presentation.main.MainActivity
import com.oguzhanorhan.kotlinmqttexample.presentation.main.MainActivityViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import org.kodein.di.generic.provider



class MqttApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MqttApplication))

        bind() from singleton { MQTTConnectionParams("MQTTSample", "YOUR_HOST","YOUR_TOPIC","","") }
        bind() from singleton { MQTTmanager(instance(), this@MqttApplication)}
        bind() from singleton { MQTTRepository(instance()) }
        bind() from provider { MainActivityViewModelFactory(instance()) }
    }
}