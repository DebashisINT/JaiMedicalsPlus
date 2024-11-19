package com.breezefieldjaimedicalplus.features.nearbyuserlist.api

import com.breezefieldjaimedicalplus.app.Pref
import com.breezefieldjaimedicalplus.features.nearbyuserlist.model.NearbyUserResponseModel
import com.breezefieldjaimedicalplus.features.newcollection.model.NewCollectionListResponseModel
import com.breezefieldjaimedicalplus.features.newcollection.newcollectionlistapi.NewCollectionListApi
import io.reactivex.Observable

class NearbyUserRepo(val apiService: NearbyUserApi) {
    fun nearbyUserList(): Observable<NearbyUserResponseModel> {
        return apiService.getNearbyUserList(Pref.session_token!!, Pref.user_id!!)
    }
}