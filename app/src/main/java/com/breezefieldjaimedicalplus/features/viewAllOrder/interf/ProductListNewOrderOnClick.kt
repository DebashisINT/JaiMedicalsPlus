package com.breezefieldjaimedicalplus.features.viewAllOrder.interf

import com.breezefieldjaimedicalplus.app.domain.NewOrderGenderEntity
import com.breezefieldjaimedicalplus.app.domain.NewOrderProductEntity

interface ProductListNewOrderOnClick {
    fun productListOnClick(product: NewOrderProductEntity)
}