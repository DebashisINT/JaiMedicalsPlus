package com.breezefieldjaimedicalplus.features.stockAddCurrentStock.api

import com.breezefieldjaimedicalplus.features.location.shopRevisitStatus.ShopRevisitStatusApi
import com.breezefieldjaimedicalplus.features.location.shopRevisitStatus.ShopRevisitStatusRepository

object ShopAddStockProvider {
    fun provideShopAddStockRepository(): ShopAddStockRepository {
        return ShopAddStockRepository(ShopAddStockApi.create())
    }
}