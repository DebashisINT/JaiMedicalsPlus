package com.breezefieldjaimedicalplus.features.photoReg.present

import com.breezefieldjaimedicalplus.app.domain.ProspectEntity
import com.breezefieldjaimedicalplus.features.photoReg.model.UserListResponseModel

interface DsStatusListner {
    fun getDSInfoOnLick(obj: ProspectEntity)
}