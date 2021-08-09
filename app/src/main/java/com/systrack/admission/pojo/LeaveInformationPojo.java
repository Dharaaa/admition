package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeaveInformationPojo {
    @SerializedName("LeaveInformation")
    @Expose
    private List<LeaveInformation> leaveInformation = null;

    public List<LeaveInformation> getLeaveInformation() {
        return leaveInformation;
    }

    public void setLeaveInformation(List<LeaveInformation> leaveInformation) {
        this.leaveInformation = leaveInformation;
    }
}
