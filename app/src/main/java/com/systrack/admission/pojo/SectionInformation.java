package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SectionInformation {
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("STREAMTYPE")
    @Expose
    private String sTREAMTYPE;
    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getSTREAMTYPE() {
        return sTREAMTYPE;
    }

    public void setSTREAMTYPE(String sTREAMTYPE) {
        this.sTREAMTYPE = sTREAMTYPE;
    }

}