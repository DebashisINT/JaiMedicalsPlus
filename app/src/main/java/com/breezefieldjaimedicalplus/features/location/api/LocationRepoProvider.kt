package com.breezefieldjaimedicalplus.features.location.api

import com.breezefieldjaimedicalplus.features.location.shopdurationapi.ShopDurationApi
import com.breezefieldjaimedicalplus.features.location.shopdurationapi.ShopDurationRepository


object LocationRepoProvider {
    fun provideLocationRepository(): LocationRepo {
        return LocationRepo(LocationApi.create())
    }
}