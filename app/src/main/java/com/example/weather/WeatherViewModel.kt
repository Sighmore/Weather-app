package com.example.weather


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.API.Constant
import com.example.weather.API.NetworkResponse
import com.example.weather.API.RetrofitInstance
import com.example.weather.API.WeatherModel
import kotlinx.coroutines.launch

//inherits from viewModel
class WeatherViewModel: ViewModel() {

    private val weatherApi = RetrofitInstance.weatherApi
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult : LiveData<NetworkResponse<WeatherModel>> = _weatherResult

    //function to get data whenever a button is clicked
    fun getData(city: String){

        -weatherResult.value= NetworkResponse.Loading
        //coroutine
       viewModelScope.launch {
           try {
               val response=weatherApi.getWeather(Constant.apiKey,city)
               if(response.isSuccessful){
                   response.body()?.let {
                       _weatherResult.value=NetworkResponse.Success(it)
                   }

               }else{

                   _weatherResult.value=NetworkResponse.Error("Failed to load data")

               }
           }catch (e: Exception){
               _weatherResult.value=NetworkResponse.Error("Failed to load data")
           }
       }
    }

}