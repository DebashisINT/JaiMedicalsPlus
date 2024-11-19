package com.breezefieldjaimedicalplus.features.login.api.global_config

import com.breezefieldjaimedicalplus.features.login.model.globalconfig.ConfigFetchResponseModel
import io.reactivex.Observable

/**
 * Created by Saikat on 14-01-2019.
 */
class ConfigFetchRepo(val apiService: ConfigFetchApi) {
    fun configFetch(): Observable<ConfigFetchResponseModel> {
        return apiService.getConfigResponse()
    }
}