package com.breezefieldjaimedicalplus.features.addshop.model

import com.breezefieldjaimedicalplus.LoanDispositionEntity
import com.breezefieldjaimedicalplus.app.domain.LoanDetailFetchEntity
import com.breezefieldjaimedicalplus.app.domain.LoanFinalStatusEntity
import com.breezefieldjaimedicalplus.app.domain.LoanRiskTypeEntity
import com.breezefieldjaimedicalplus.app.domain.ShopAudioEntity
import com.breezefieldjaimedicalplus.app.domain.StockAllEntity
import com.breezefieldjaimedicalplus.base.BaseResponse
import java.io.Serializable

/**
 * Created by Saikat on 14-May-20.
 */
data class AreaListResponseModel(var area_list: ArrayList<AreaListDataModel>? = null) : BaseResponse(), Serializable

data class AreaListDataModel(var area_id: String = "",
                             var area_name: String = "") : Serializable

data class TypeListResponseModel(var type_list: ArrayList<TypeListDataModel>? = null) : BaseResponse(), Serializable

data class TypeListDataModel(var id: String = "",
                             var name: String = "",
                             var type_id: String = "") : Serializable

data class EntityResponseModel(var entity_type: ArrayList<TypeListDataModel>? = null): BaseResponse(), Serializable

data class PartyStatusResponseModel(var party_status: ArrayList<TypeListDataModel>? = null): BaseResponse(), Serializable

data class RetailerListResponseModel(var retailer_list: ArrayList<TypeListDataModel>? = null): BaseResponse(), Serializable

data class DealerListResponseModel(var dealer_list: ArrayList<TypeListDataModel>? = null): BaseResponse(), Serializable

data class BeatListResponseModel(var beat_list: ArrayList<TypeListDataModel>? = null): BaseResponse(), Serializable

data class AssignedToShopListResponseModel(var shop_list: ArrayList<AssignedToShopListDataModel>?= null) : BaseResponse(), Serializable

data class AssignedToShopListDataModel(var assigned_to_shop_id: String = "",
                                       var name: String = "",
                                       var phn_no: String = "",
                                       var type_id: String = ""): Serializable

data class BetAreaRouteResponseModel(var status:String,var message:String, var user_id:String, var PLAN_ASSNBEATID:String,
var PLAN_ASSNBEATName:String,
var PLAN_ASSNAREAID:String,
var PLAN_ASSNAREAName:String,
var PLAN_ASSNROUTEID:String,
var PLAN_ASSNROUTEName:String)

data class AudioFetchDataCLass(var audio_list:ArrayList<AudioFetchData> = ArrayList()):BaseResponse()

data class AudioFetchData(var shop_id:String="",var audio_path:String="",var isUploaded:String="",var datetime:String="",var revisitORvisit:String="")

data class StockAllResponse (var stock_list:ArrayList<StockAllEntity>):BaseResponse()

data class LoanRiskTypeListsResponse (var data_list:ArrayList<LoanRiskTypeEntity>):BaseResponse()

data class LoanDispositionListsResponse (var data_list:ArrayList<LoanDispositionEntity>):BaseResponse()

data class LoanFinalStatusListsResponse (var data_list:ArrayList<LoanFinalStatusEntity>):BaseResponse()

data class LoanDetailFetchListsResponse (var data_list:ArrayList<LoanDetailFetchEntity>):BaseResponse()

/*data class StockData(var stock_shopcode:String="",var stock_shopentitycode:String = "",var stock_productid:String = "",
                     var stock_productname:String="",var stock_productqty:String="",var stock_productbalqty:String="")*/


