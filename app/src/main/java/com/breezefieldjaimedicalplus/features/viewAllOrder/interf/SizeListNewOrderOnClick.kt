package com.breezefieldjaimedicalplus.features.viewAllOrder.interf

import com.breezefieldjaimedicalplus.app.domain.NewOrderProductEntity
import com.breezefieldjaimedicalplus.app.domain.NewOrderSizeEntity

interface SizeListNewOrderOnClick {
    fun sizeListOnClick(size: NewOrderSizeEntity)
}