package com.breezefieldjaimedicalplus.features.mylearning.apiCall

import com.breezefieldjaimedicalplus.features.login.api.opportunity.OpportunityListApi
import com.breezefieldjaimedicalplus.features.login.api.opportunity.OpportunityListRepo

object LMSRepoProvider {
    fun getTopicList(): LMSRepo {
        return LMSRepo(LMSApi.create())
    }
}