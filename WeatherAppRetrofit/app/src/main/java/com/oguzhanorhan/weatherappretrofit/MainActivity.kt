package com.oguzhanorhan.weatherappretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.oguzhanorhan.weatherappretrofit.RetrofitUtils.WeatherResponse
import com.oguzhanorhan.weatherappretrofit.RetrofitUtils.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit  var button : Button
    lateinit var weatherText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    fun initUI() {
        button = findViewById(R.id.button)
        weatherText = findViewById(R.id.textView)
    }

    fun getWeatherStatus(view: View) {
        val retrofitInstance = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofitInstance.create(WeatherService::class.java)
        val apiCall = service.getCurrentWeatherData(lat, lon, AppId)

        apiCall.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>
            ) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()

                    Toast.makeText(this@MainActivity, weatherResponse!!.weather[0].description,Toast.LENGTH_LONG).show()
                    weatherText.text= weatherResponse.weather[0].description.toString()
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Error",Toast.LENGTH_LONG).show()
            }
        })
    }

    companion object {

        var BaseUrl = "https://api.openweathermap.org/"
        var AppId = "2e65127e909e178d0af311a81f39948c"
        var lat = "38.314314"
        var lon = "26.635692"
    }
}
