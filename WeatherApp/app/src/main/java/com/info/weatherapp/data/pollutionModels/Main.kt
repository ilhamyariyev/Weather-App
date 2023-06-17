package com.info.weatherapp.data.pollutionModels


import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("aqi")
    val aqi: Int?
)