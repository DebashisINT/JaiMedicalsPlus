package com.breezefieldjaimedicalplus.features.login.model.alarmconfigmodel

import com.breezefieldjaimedicalplus.base.BaseResponse

/**
 * Created by Saikat on 19-02-2019.
 */
class AlarmConfigResponseModel : BaseResponse() {
    var alarm_settings_list: ArrayList<AlarmConfigDataModel>? = null
}