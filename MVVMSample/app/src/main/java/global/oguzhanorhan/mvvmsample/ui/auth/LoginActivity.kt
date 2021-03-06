package global.oguzhanorhan.mvvmsample.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import global.oguzhanorhan.mvvmsample.R
import global.oguzhanorhan.mvvmsample.data.db.entities.User
import global.oguzhanorhan.mvvmsample.databinding.ActivityLoginBinding
import global.oguzhanorhan.mvvmsample.ui.general.HomeActivity
import global.oguzhanorhan.mvvmsample.utils.*
import kotlinx.android.synthetic.main.activity_login.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthListener, KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val vm = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)
        binding.viewModel = vm
        vm.authListener = this

        vm.getUserLoggedIn().observe(this, Observer { user ->
            if (user != null) {
                Intent(this, HomeActivity::class.java).also {
                    it.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }

    override fun onStarted() {
        progress_bar.show()
        toastShort("Login started")
        root_layout.snackbar("Login started")
    }

    override fun onSuccess(user: User) {
        toastLong(user.name+" is logged in")
        root_layout.snackbar(user.name+" is logged in")
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toastLong(message)
        root_layout.snackbar(message)
    }
}
