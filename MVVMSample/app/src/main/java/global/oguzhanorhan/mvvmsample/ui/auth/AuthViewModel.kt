package global.oguzhanorhan.mvvmsample.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import global.oguzhanorhan.mvvmsample.data.repositories.UserRepository
import global.oguzhanorhan.mvvmsample.utils.ApiException
import global.oguzhanorhan.mvvmsample.utils.CoroutinesUtil

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

        CoroutinesUtil.main {
            try {
                val authResponse = UserRepository().userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            }
            catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            }
        }



    }
}