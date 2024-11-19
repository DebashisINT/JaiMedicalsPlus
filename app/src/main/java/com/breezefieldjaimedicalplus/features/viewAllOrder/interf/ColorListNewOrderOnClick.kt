package com.breezefieldjaimedicalplus.features.viewAllOrder.interf

import com.breezefieldjaimedicalplus.app.domain.NewOrderColorEntity
import com.breezefieldjaimedicalplus.app.domain.NewOrderProductEntity

interface ColorListNewOrderOnClick {
    fun productListOnClick(color: NewOrderColorEntity)
}