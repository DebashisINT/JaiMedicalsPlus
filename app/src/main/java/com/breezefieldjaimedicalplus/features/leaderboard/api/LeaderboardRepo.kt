package com.breezefieldjaimedicalplus.features.leaderboard.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import com.fasterxml.jackson.databind.ObjectMapper
import com.breezefieldjaimedicalplus.app.FileUtils
import com.breezefieldjaimedicalplus.app.Pref
import com.breezefieldjaimedicalplus.base.BaseResponse
import com.breezefieldjaimedicalplus.features.addshop.model.AddLogReqData
import com.breezefieldjaimedicalplus.features.addshop.model.AddShopRequestData
import com.breezefieldjaimedicalplus.features.addshop.model.AddShopResponse
import com.breezefieldjaimedicalplus.features.addshop.model.LogFileResponse
import com.breezefieldjaimedicalplus.features.addshop.model.UpdateAddrReq
import com.breezefieldjaimedicalplus.features.contacts.CallHisDtls
import com.breezefieldjaimedicalplus.features.contacts.CompanyReqData
import com.breezefieldjaimedicalplus.features.contacts.ContactMasterRes
import com.breezefieldjaimedicalplus.features.contacts.SourceMasterRes
import com.breezefieldjaimedicalplus.features.contacts.StageMasterRes
import com.breezefieldjaimedicalplus.features.contacts.StatusMasterRes
import com.breezefieldjaimedicalplus.features.contacts.TypeMasterRes
import com.breezefieldjaimedicalplus.features.dashboard.presentation.DashboardActivity
import com.breezefieldjaimedicalplus.features.login.model.WhatsappApiData
import com.breezefieldjaimedicalplus.features.login.model.WhatsappApiFetchData
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

/**
 * Created by Puja on 10-10-2024.
 */
class LeaderboardRepo(val apiService: LeaderboardApi) {

    fun branchlist(session_token: String): Observable<LeaderboardBranchData> {
        return apiService.branchList(session_token)
    }
    fun ownDatalist(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOwnData> {
        return apiService.ownDatalist(user_id,activitybased,branchwise,flag)
    }
    fun overAllAPI(user_id: String,activitybased: String,branchwise: String,flag: String): Observable<LeaderboardOverAllData> {
        return apiService.overAllDatalist(user_id,activitybased,branchwise,flag)
    }
}