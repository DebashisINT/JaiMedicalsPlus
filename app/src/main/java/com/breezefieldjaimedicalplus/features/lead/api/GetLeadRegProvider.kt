package com.breezefieldjaimedicalplus.features.lead.api

import com.breezefieldjaimedicalplus.features.NewQuotation.api.GetQuotListRegRepository
import com.breezefieldjaimedicalplus.features.NewQuotation.api.GetQutoListApi


object GetLeadRegProvider {
    fun provideList(): GetLeadListRegRepository {
        return GetLeadListRegRepository(GetLeadListApi.create())
    }
}