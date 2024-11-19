package com.breezefieldjaimedicalplus.features.login.model

import com.breezefieldjaimedicalplus.app.domain.QuestionSubmitEntity


class GetQtsAnsSubmitDtlsResponseModel {
    var status:String? = null
    var message:String? = null
    var Question_list: ArrayList<QuestionSubmitEntity>? = null
}