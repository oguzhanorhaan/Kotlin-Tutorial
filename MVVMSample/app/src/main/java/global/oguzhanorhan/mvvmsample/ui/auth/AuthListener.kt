package global.oguzhanorhan.mvvmsample.ui.auth

import androidx.lifecycle.LiveData
import global.oguzhanorhan.mvvmsample.data.db.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}