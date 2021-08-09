package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PublishMarkSheetInformationPojo {
    @SerializedName("PublishMarkSheetInformation")
    @Expose
    private List<PublishMarkSheetInformation> publishMarkSheetInformation = null;

    public List<PublishMarkSheetInformation> getPublishMarkSheetInformation() {
        return publishMarkSheetInformation;
    }

    public void setPublishMarkSheetInformation(List<PublishMarkSheetInformation> publishMarkSheetInformation) {
        this.publishMarkSheetInformation = publishMarkSheetInformation;
    }
}
