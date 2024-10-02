package com.example.weather


import android.util.Log
import androidx.lifecycle.ViewModel
//inherits from viewModel
class WeatherViewModel: ViewModel() {

    //function to get data whenever a button is clicked
    fun getData(city: String){
        Log.i("City name: ",city)
    }

}