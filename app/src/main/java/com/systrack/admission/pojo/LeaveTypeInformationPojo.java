package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeaveTypeInformationPojo {
    @SerializedName("LeaveTypeInformation")
    @Expose
    private List<LeaveTypeInformation> leaveTypeInformation = null;

    public List<LeaveTypeInformation> getLeaveTypeInformation() {
        return leaveTypeInformation;
    }

    public void setLeaveTypeInformation(List<LeaveTypeInformation> leaveTypeInformation) {
        this.leaveTypeInformation = leaveTypeInformation;
    }
}
