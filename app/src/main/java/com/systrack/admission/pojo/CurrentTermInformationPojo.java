package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentTermInformationPojo {
    @SerializedName("CurrentTermInformation")
    @Expose
    private List<CurrentTermInformation> currentTermInformation = null;

    public List<CurrentTermInformation> getCurrentTermInformation() {
        return currentTermInformation;
    }

    public void setCurrentTermInformation(List<CurrentTermInformation> currentTermInformation) {
        this.currentTermInformation = currentTermInformation;
    }
}
