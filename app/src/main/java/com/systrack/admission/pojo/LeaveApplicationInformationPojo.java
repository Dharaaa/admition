package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeaveApplicationInformationPojo {
    @SerializedName("LeaveApplicationInformation")
    @Expose
    private List<LeaveApplicationInformation> leaveApplicationInformation = null;

    public List<LeaveApplicationInformation> getLeaveApplicationInformation() {
        return leaveApplicationInformation;
    }

    public void setLeaveApplicationInformation(List<LeaveApplicationInformation> leaveApplicationInformation) {
        this.leaveApplicationInformation = leaveApplicationInformation;
    }
}
