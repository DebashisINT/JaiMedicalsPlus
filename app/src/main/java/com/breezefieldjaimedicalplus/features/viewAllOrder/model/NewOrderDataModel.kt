package com.breezefieldjaimedicalplus.features.viewAllOrder.model

import com.breezefieldjaimedicalplus.app.domain.NewOrderColorEntity
import com.breezefieldjaimedicalplus.app.domain.NewOrderGenderEntity
import com.breezefieldjaimedicalplus.app.domain.NewOrderProductEntity
import com.breezefieldjaimedicalplus.app.domain.NewOrderSizeEntity
import com.breezefieldjaimedicalplus.features.stockCompetetorStock.model.CompetetorStockGetDataDtls

class NewOrderDataModel {
    var status:String ? = null
    var message:String ? = null
    var Gender_list :ArrayList<NewOrderGenderEntity>? = null
    var Product_list :ArrayList<NewOrderProductEntity>? = null
    var Color_list :ArrayList<NewOrderColorEntity>? = null
    var size_list :ArrayList<NewOrderSizeEntity>? = null
}

