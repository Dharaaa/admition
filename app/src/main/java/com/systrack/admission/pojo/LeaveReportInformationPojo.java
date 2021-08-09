package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeaveReportInformationPojo {
    @SerializedName("LeaveReportInformation")
    @Expose
    private List<LeaveReportInformation> leaveReportInformation = null;

    public List<LeaveReportInformation> getLeaveReportInformation() {
        return leaveReportInformation;
    }

    public void setLeaveReportInformation(List<LeaveReportInformation> leaveReportInformation) {
        this.leaveReportInformation = leaveReportInformation;
    }
}
