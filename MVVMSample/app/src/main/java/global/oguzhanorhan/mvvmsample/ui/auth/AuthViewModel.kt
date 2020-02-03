package global.oguzhanorhan.mvvmsample.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import global.oguzhanorhan.mvvmsample.data.repositories.UserRepository
import global.oguzhanorhan.mvvmsample.utils.ApiException
import global.oguzhanorhan.mvvmsample.utils.CoroutinesUtil
import global.oguzhanorhan.mvvmsample.utils.NoInternetException

open class AuthViewModel(
    private val  repository: UserRepository
) : ViewModel() {
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClicked(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Username or password is empty")
            return
        }

        CoroutinesUtil.main {
            try {
                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUserToDb(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            }
            catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            }
            catch (e: NoInternetException) {
                authListener?.onFailure(e.message!!)
            }
        }
    }

      fun getUserLoggedIn() = repository.getUser()

}