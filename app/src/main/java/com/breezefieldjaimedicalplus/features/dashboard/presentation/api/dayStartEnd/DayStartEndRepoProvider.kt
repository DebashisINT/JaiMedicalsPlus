package com.breezefieldjaimedicalplus.features.dashboard.presentation.api.dayStartEnd

import com.breezefieldjaimedicalplus.features.stockCompetetorStock.api.AddCompStockApi
import com.breezefieldjaimedicalplus.features.stockCompetetorStock.api.AddCompStockRepository

object DayStartEndRepoProvider {
    fun dayStartRepositiry(): DayStartEndRepository {
        return DayStartEndRepository(DayStartEndApi.create())
    }

}