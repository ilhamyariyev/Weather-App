package com.info.weatherapp.data

import com.info.weatherapp.data.forecastModels.Forecast
import com.info.weatherapp.data.models.CurrentWeather
import com.info.weatherapp.data.pollutionModels.PollutionModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("weather?")
    suspend fun getCurrentWeather(
        @Query("q") city : String,
        @Query("units") units : String,
        @Query("appid") apiKey : String,
    ):Response<CurrentWeather>

    @GET("forecast?")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("units") units : String,
        @Query("appid") apiKey : String,
    ) : Response<Forecast>

    @GET("air_pollution?")
    suspend fun getPollution(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units : String,
        @Query("appid") apiKey : String,
    ):Response<PollutionModels>
}