package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeaveDurationInformationPojo {
    @SerializedName("LeaveDurationInformation")
    @Expose
    private List<LeaveDurationInformation> leaveDurationInformation = null;

    public List<LeaveDurationInformation> getLeaveDurationInformation() {
        return leaveDurationInformation;
    }

    public void setLeaveDurationInformation(List<LeaveDurationInformation> leaveDurationInformation) {
        this.leaveDurationInformation = leaveDurationInformation;
    }
}
