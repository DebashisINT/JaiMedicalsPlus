package com.breezefieldjaimedicalplus.features.survey.api

import com.breezefieldjaimedicalplus.features.photoReg.api.GetUserListPhotoRegApi
import com.breezefieldjaimedicalplus.features.photoReg.api.GetUserListPhotoRegRepository

object SurveyDataProvider{

    fun provideSurveyQ(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.create())
    }

    fun provideSurveyQMultiP(): SurveyDataRepository {
        return SurveyDataRepository(SurveyDataApi.createImage())
    }
}