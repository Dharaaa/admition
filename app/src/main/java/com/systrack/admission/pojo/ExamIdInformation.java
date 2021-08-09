package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExamIdInformation {

    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("CurrentInternalExamId")
    @Expose
    private String currentInternalExamId;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCurrentInternalExamId() {
        return currentInternalExamId;
    }

    public void setCurrentInternalExamId(String currentInternalExamId) {
        this.currentInternalExamId = currentInternalExamId;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
