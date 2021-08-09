package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BatchInformationPojo {
    @SerializedName("BatchInformation")
    @Expose
    private List<BatchInformation> batchInformation = null;

    public List<BatchInformation> getBatchInformation() {
        return batchInformation;
    }

    public void setBatchInformation(List<BatchInformation> batchInformation) {
        this.batchInformation = batchInformation;
    }
}
