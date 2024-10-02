package com.example.weather


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.API.Constant
import com.example.weather.API.RetrofitInstance
import kotlinx.coroutines.launch

//inherits from viewModel
class WeatherViewModel: ViewModel() {

    private val weatherApi = RetrofitInstance.weatherApi

    //function to get data whenever a button is clicked
    fun getData(city: String){
       viewModelScope.launch {
           val response=weatherApi.getWeather(Constant.apiKey,city)
           if(response.isSuccessful){
               Log.i("Response: ", response.body().toString())
           }else{
               Log.i("Error: ",response.message())
           }
       }
    }

}