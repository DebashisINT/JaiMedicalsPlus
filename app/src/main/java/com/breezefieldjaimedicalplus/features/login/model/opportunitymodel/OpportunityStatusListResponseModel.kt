package com.breezefieldjaimedicalplus.features.login.model.opportunitymodel

import com.breezefieldjaimedicalplus.app.domain.OpportunityStatusEntity
import com.breezefieldjaimedicalplus.app.domain.ProductListEntity
import com.breezefieldjaimedicalplus.base.BaseResponse

/**
 * Created by Puja on 30.05.2024
 */
class OpportunityStatusListResponseModel : BaseResponse() {
    var status_list: ArrayList<OpportunityStatusEntity>? = null
}