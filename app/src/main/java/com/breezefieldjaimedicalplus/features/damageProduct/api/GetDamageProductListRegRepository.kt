package com.breezefieldjaimedicalplus.features.damageProduct.api

import android.content.Context
import android.net.Uri
import android.text.TextUtils
import android.util.Log
import com.breezefieldjaimedicalplus.app.FileUtils
import com.breezefieldjaimedicalplus.base.BaseResponse
import com.breezefieldjaimedicalplus.features.NewQuotation.model.*
import com.breezefieldjaimedicalplus.features.addshop.model.AddShopRequestData
import com.breezefieldjaimedicalplus.features.addshop.model.AddShopResponse
import com.breezefieldjaimedicalplus.features.damageProduct.model.DamageProductResponseModel
import com.breezefieldjaimedicalplus.features.damageProduct.model.delBreakageReq
import com.breezefieldjaimedicalplus.features.damageProduct.model.viewAllBreakageReq
import com.breezefieldjaimedicalplus.features.login.model.userconfig.UserConfigResponseModel
import com.breezefieldjaimedicalplus.features.myjobs.model.WIPImageSubmit
import com.breezefieldjaimedicalplus.features.photoReg.model.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class GetDamageProductListRegRepository(val apiService : GetDamageProductListApi) {

    fun viewBreakage(req: viewAllBreakageReq): Observable<DamageProductResponseModel> {
        return apiService.viewBreakage(req)
    }

    fun delBreakage(req: delBreakageReq): Observable<BaseResponse>{
        return apiService.BreakageDel(req.user_id!!,req.breakage_number!!,req.session_token!!)
    }

}