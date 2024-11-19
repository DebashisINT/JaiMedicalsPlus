package com.breezefieldjaimedicalplus.features.login.model.productlistmodel

import com.breezefieldjaimedicalplus.app.domain.ModelEntity
import com.breezefieldjaimedicalplus.app.domain.ProductListEntity
import com.breezefieldjaimedicalplus.base.BaseResponse

class ModelListResponse: BaseResponse() {
    var model_list: ArrayList<ModelEntity>? = null
}