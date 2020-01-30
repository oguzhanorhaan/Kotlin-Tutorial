package global.oguzhanorhan.mvvmsample.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import global.oguzhanorhan.mvvmsample.R
import global.oguzhanorhan.mvvmsample.databinding.ActivityLoginBinding
import global.oguzhanorhan.mvvmsample.utils.hide
import global.oguzhanorhan.mvvmsample.utils.show
import global.oguzhanorhan.mvvmsample.utils.toastLong
import global.oguzhanorhan.mvvmsample.utils.toastShort
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val vm = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewModel = vm
        vm.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()
        toastShort("Login started")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            progress_bar.visibility = View.GONE
            toastLong(it)
            progress_bar.hide()
        })
    }

    override fun onFailure(message: String) {
        toastLong(message)
    }
}
