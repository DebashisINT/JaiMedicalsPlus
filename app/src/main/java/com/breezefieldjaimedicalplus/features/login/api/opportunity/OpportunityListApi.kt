package com.breezefieldjaimedicalplus.features.login.api.opportunity

import com.breezefieldjaimedicalplus.app.NetworkConstant
import com.breezefieldjaimedicalplus.base.BaseResponse
import com.breezefieldjaimedicalplus.features.addshop.model.AudioFetchDataCLass
import com.breezefieldjaimedicalplus.features.addshop.model.LoanDetailFetchListsResponse
import com.breezefieldjaimedicalplus.features.addshop.model.LoanDispositionListsResponse
import com.breezefieldjaimedicalplus.features.addshop.model.LoanFinalStatusListsResponse
import com.breezefieldjaimedicalplus.features.addshop.model.LoanRiskTypeListsResponse
import com.breezefieldjaimedicalplus.features.addshop.model.StockAllResponse
import com.breezefieldjaimedicalplus.features.dashboard.presentation.DashboardActivity
import com.breezefieldjaimedicalplus.features.login.model.opportunitymodel.OpportunityStatusListResponseModel
import com.breezefieldjaimedicalplus.features.login.model.productlistmodel.ProductListResponseModel
import com.breezefieldjaimedicalplus.features.orderITC.SyncDeleteOppt
import com.breezefieldjaimedicalplus.features.orderITC.SyncEditOppt
import com.breezefieldjaimedicalplus.features.orderITC.SyncOppt
import com.breezefieldjaimedicalplus.features.orderITC.SyncOrd
import com.breezefieldjaimedicalplus.features.orderList.model.OpportunityListResponseModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Saikat on 20-11-2018.
 */
interface OpportunityListApi {
    @FormUrlEncoded
    @POST("CRMOpportunityDetails/OpportunityStatusList")
    fun getOpportunityStatusList(@Field("session_token") session_token: String): Observable<OpportunityStatusListResponseModel>

    @POST("CRMOpportunityDetails/OpportunityDetailSave")
    fun saveOpportunity(@Body syncOppt: SyncOppt): Observable<BaseResponse>

    @POST("CRMOpportunityDetails/OpportunityDetailEdit")
    fun editOpportunity(@Body syncEditOppt: SyncEditOppt): Observable<BaseResponse>

    @POST("CRMOpportunityDetails/OpportunityDetailDelete")
    fun deleteOpportunity(@Body syncDeleteOppt: SyncDeleteOppt): Observable<BaseResponse>

    @FormUrlEncoded
    @POST("CRMOpportunityDetails/OpportunityDetailLists")
    fun getOpportunityL(@Field("user_id") user_id: String): Observable<OpportunityListResponseModel>

    @FormUrlEncoded
    @POST("Shoplist/FetchShopRevisitAudio")
    fun getAudioLApi(@Field("user_id") user_id: String,@Field("data_limit_in_days") data_limit_in_days:String): Observable<AudioFetchDataCLass>

    @POST("LMSInfoDetails/UserWiseLMSModulesInfo")
    fun saveLMSModuleInfoApi(@Body obj: DashboardActivity.LMSModule): Observable<BaseResponse>

    @FormUrlEncoded
    @POST("OrderWithStockMgmtDetails/ListForProductStock")
    fun getAllStockApi(@Field("user_id") user_id: String): Observable<StockAllResponse>

    @FormUrlEncoded
    @POST("LoanInfoDetails/LoanRiskTypeLists")
    fun getLoanRiskTypeLists(@Field("user_id") user_id: String): Observable<LoanRiskTypeListsResponse>

    @FormUrlEncoded
    @POST("LoanInfoDetails/LoanDispositionLists")
    fun getLoanDispositionLists(@Field("user_id") user_id: String): Observable<LoanDispositionListsResponse>


    @FormUrlEncoded
    @POST("LoanInfoDetails/LoanFinalStatusLists")
    fun getLoanFinalStatusLists(@Field("user_id") user_id: String): Observable<LoanFinalStatusListsResponse>


    @FormUrlEncoded
    @POST("LoanInfoDetails/LoanDetailFetch")
    fun getLoanDetailFetch(@Field("user_id") user_id: String): Observable<LoanDetailFetchListsResponse>


    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): OpportunityListApi {
            val retrofit = Retrofit.Builder()
                    .client(NetworkConstant.setTimeOut())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(NetworkConstant.BASE_URL)
                    .build()

            return retrofit.create(OpportunityListApi::class.java)
        }
    }
}