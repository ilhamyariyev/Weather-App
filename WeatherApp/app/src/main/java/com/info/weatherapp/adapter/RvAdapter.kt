package com.info.weatherapp.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.info.weatherapp.data.forecastModels.ForecastData
import com.info.weatherapp.databinding.RvItemLayoutBinding
import com.squareup.picasso.Picasso
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


class RvAdapter(private val forecastArray: ArrayList<ForecastData>) :RecyclerView.Adapter<RvAdapter.ViewHolder>(){

    class ViewHolder(val binding:RvItemLayoutBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return forecastArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = forecastArray[position]

        holder.binding.apply {
            val imageIcon = currentItem.weather!!.get(0)!!.icon
            val imageUrl = "https://openweathermap.org/img/w/$imageIcon.png"

            Picasso.get().load(imageUrl).into(imgItem)

            tvItemTemp.text = "${currentItem.main!!.temp!!.toInt()}°C"
            tvItemStatus.text = "${currentItem.weather.get(0)!!.description}"
            tvItemTime.text  =displayTime(currentItem.dtTxt)
        }
    }

    private fun displayTime(dtTxt: String?): CharSequence? {
        val input = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:00")
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        val output = DateTimeFormatter.ofPattern("MM-dd HH:mm")
        val dateTime = LocalDateTime.parse(dtTxt,input)
        return output.format(dateTime)
    }


}