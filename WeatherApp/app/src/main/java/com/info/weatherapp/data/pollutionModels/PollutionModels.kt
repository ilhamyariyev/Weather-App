package com.info.weatherapp.data.pollutionModels


import com.google.gson.annotations.SerializedName

data class PollutionModels(
    @SerializedName("coord")
    val coord:Coord?,
    @SerializedName("list")
    val list: List<Pollution>?
)