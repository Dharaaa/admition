package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PublishExamTimeTableInformationPojo {
    @SerializedName("PublishExamTimeTableInformation")
    @Expose
    private List<PublishExamTimeTableInformation> publishExamTimeTableInformation = null;

    public List<PublishExamTimeTableInformation> getPublishExamTimeTableInformation() {
        return publishExamTimeTableInformation;
    }

    public void setPublishExamTimeTableInformation(List<PublishExamTimeTableInformation> publishExamTimeTableInformation) {
        this.publishExamTimeTableInformation = publishExamTimeTableInformation;
    }
}
