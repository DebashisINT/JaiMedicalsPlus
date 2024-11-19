package com.breezefieldjaimedicalplus.features.viewAllOrder.orderOptimized

import com.breezefieldjaimedicalplus.app.domain.ProductOnlineRateTempEntity
import com.breezefieldjaimedicalplus.base.BaseResponse
import com.breezefieldjaimedicalplus.features.login.model.productlistmodel.ProductRateDataModel
import java.io.Serializable

class ProductRateOnlineListResponseModel: BaseResponse(), Serializable {
    var product_rate_list: ArrayList<ProductOnlineRateTempEntity>? = null
}