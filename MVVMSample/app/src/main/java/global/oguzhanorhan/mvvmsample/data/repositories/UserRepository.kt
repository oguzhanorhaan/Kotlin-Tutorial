package global.oguzhanorhan.mvvmsample.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import global.oguzhanorhan.mvvmsample.data.network.MyAPI
import global.oguzhanorhan.mvvmsample.data.network.SafeApiRequest
import global.oguzhanorhan.mvvmsample.data.network.responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository : SafeApiRequest(){

    suspend fun userLogin(email: String, password: String): AuthResponse{

        return apiRequest { MyAPI().userLogin(email, password) }
    }
}