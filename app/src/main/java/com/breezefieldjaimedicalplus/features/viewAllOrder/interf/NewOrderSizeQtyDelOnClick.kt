package com.breezefieldjaimedicalplus.features.viewAllOrder.interf

import com.breezefieldjaimedicalplus.app.domain.NewOrderGenderEntity
import com.breezefieldjaimedicalplus.features.viewAllOrder.model.ProductOrder
import java.text.FieldPosition

interface NewOrderSizeQtyDelOnClick {
    fun sizeQtySelListOnClick(product_size_qty: ArrayList<ProductOrder>)
    fun sizeQtyListOnClick(product_size_qty: ProductOrder,position: Int)
}