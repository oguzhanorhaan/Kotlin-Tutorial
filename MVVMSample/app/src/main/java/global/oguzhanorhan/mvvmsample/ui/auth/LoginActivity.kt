package global.oguzhanorhan.mvvmsample.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import global.oguzhanorhan.mvvmsample.R
import global.oguzhanorhan.mvvmsample.databinding.ActivityLoginBinding
import global.oguzhanorhan.mvvmsample.utils.toastLong

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val vm = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewModel = vm
        vm.authListener = this
    }

    override fun onStarted() {
        toastLong("Login started")
    }

    override fun onSuccess() {
        toastLong("Login successful")
    }

    override fun onFailure(message: String) {
        toastLong(message)
    }
}
