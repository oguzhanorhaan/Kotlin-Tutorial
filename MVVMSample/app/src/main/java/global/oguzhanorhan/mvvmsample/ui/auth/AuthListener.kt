package global.oguzhanorhan.mvvmsample.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {
    fun onStarted()
    fun onSuccess(value: LiveData<String>)
    fun onFailure(message: String)
}