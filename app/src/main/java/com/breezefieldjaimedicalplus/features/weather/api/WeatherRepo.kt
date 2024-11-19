package com.breezefieldjaimedicalplus.features.weather.api

import com.breezefieldjaimedicalplus.base.BaseResponse
import com.breezefieldjaimedicalplus.features.task.api.TaskApi
import com.breezefieldjaimedicalplus.features.task.model.AddTaskInputModel
import com.breezefieldjaimedicalplus.features.weather.model.ForeCastAPIResponse
import com.breezefieldjaimedicalplus.features.weather.model.WeatherAPIResponse
import io.reactivex.Observable

class WeatherRepo(val apiService: WeatherApi) {
    fun getCurrentWeather(zipCode: String): Observable<WeatherAPIResponse> {
        return apiService.getTodayWeather(zipCode)
    }

    fun getWeatherForecast(zipCode: String): Observable<ForeCastAPIResponse> {
        return apiService.getForecast(zipCode)
    }
}