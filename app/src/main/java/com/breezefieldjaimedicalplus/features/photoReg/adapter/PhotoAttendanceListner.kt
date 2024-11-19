package com.breezefieldjaimedicalplus.features.photoReg.adapter

import com.breezefieldjaimedicalplus.features.photoReg.model.UserListResponseModel

interface PhotoAttendanceListner {
    fun getUserInfoOnLick(obj: UserListResponseModel)
    fun getUserInfoAttendReportOnLick(obj: UserListResponseModel)
}