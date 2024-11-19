package com.breezefieldjaimedicalplus.features.activities.api

import com.breezefieldjaimedicalplus.features.member.api.TeamApi
import com.breezefieldjaimedicalplus.features.member.api.TeamRepo

object ActivityRepoProvider {
    fun activityRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.create())
    }

    fun activityImageRepoProvider(): ActivityRepo {
        return ActivityRepo(ActivityApi.createImage())
    }
}