package global.oguzhanorhan.mvvmsample.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

open class AuthViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClicked(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Username or password is empty")
            //todo: show alert
            return
        }
        authListener?.onSuccess()

    }
}