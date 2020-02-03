package global.oguzhanorhan.mvvmsample.data.network

import global.oguzhanorhan.mvvmsample.data.network.responses.AuthResponse
import okhttp3.OkHttpClient
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

    @FormUrlEncoded
    @POST("signup")
    suspend fun userSignup( @Field("name") name: String, @Field("email") email: String, @Field("password") password: String
    ) : Response<AuthResponse>

    companion object{
        //example based on simplified coding's API
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor) : MyAPI {

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPI::class.java)
        }
    }
}