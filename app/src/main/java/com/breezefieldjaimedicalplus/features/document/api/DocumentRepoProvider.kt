package com.breezefieldjaimedicalplus.features.document.api

import com.breezefieldjaimedicalplus.features.dymanicSection.api.DynamicApi
import com.breezefieldjaimedicalplus.features.dymanicSection.api.DynamicRepo

object DocumentRepoProvider {
    fun documentRepoProvider(): DocumentRepo {
        return DocumentRepo(DocumentApi.create())
    }

    fun documentRepoProviderMultipart(): DocumentRepo {
        return DocumentRepo(DocumentApi.createImage())
    }
}