package com.breezefieldjaimedicalplus.features.viewAllOrder.interf

import com.breezefieldjaimedicalplus.app.domain.NewOrderGenderEntity
import com.breezefieldjaimedicalplus.features.viewAllOrder.model.ProductOrder

interface ColorListOnCLick {
    fun colorListOnCLick(size_qty_list: ArrayList<ProductOrder>, adpPosition:Int)
}