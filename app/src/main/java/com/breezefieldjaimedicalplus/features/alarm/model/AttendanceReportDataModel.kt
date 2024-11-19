package com.breezefieldjaimedicalplus.features.alarm.model

import com.breezefieldjaimedicalplus.base.BaseResponse

/**
 * Created by Kinsuk on 20-02-2019.
 */
class AttendanceReportDataModel : BaseResponse() {
    var attendance_report_list: ArrayList<AttendanceReport>? = null
}