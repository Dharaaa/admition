package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BroadSheetInformationPojo {
    @SerializedName("BroadSheetInformation")
    @Expose
    private List<BroadSheetInformation> broadSheetInformation = null;

    public List<BroadSheetInformation> getBroadSheetInformation() {
        return broadSheetInformation;
    }

    public void setBroadSheetInformation(List<BroadSheetInformation> broadSheetInformation) {
        this.broadSheetInformation = broadSheetInformation;
    }


}
