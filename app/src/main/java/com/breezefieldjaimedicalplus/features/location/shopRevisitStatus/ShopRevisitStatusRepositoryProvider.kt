package com.breezefieldjaimedicalplus.features.location.shopRevisitStatus

import com.breezefieldjaimedicalplus.features.location.shopdurationapi.ShopDurationApi
import com.breezefieldjaimedicalplus.features.location.shopdurationapi.ShopDurationRepository

object ShopRevisitStatusRepositoryProvider {
    fun provideShopRevisitStatusRepository(): ShopRevisitStatusRepository {
        return ShopRevisitStatusRepository(ShopRevisitStatusApi.create())
    }
}