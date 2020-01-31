package global.oguzhanorhan.mvvmsample.data.network

import global.oguzhanorhan.mvvmsample.data.network.responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface MyAPI {
    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(@Field("email") email: String, @Field("password") password: String) : Response<AuthResponse>

    companion object{
        //example based on simplified coding's API
        operator fun invoke() : MyAPI {
            return Retrofit.Builder()
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPI::class.java)
        }
    }
}