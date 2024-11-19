package com.breezefieldjaimedicalplus.features.weather.api

import com.breezefieldjaimedicalplus.features.task.api.TaskApi
import com.breezefieldjaimedicalplus.features.task.api.TaskRepo

object WeatherRepoProvider {
    fun weatherRepoProvider(): WeatherRepo {
        return WeatherRepo(WeatherApi.create())
    }
}