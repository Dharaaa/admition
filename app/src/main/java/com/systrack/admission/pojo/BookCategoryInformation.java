package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookCategoryInformation
{
    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("SID")
    @Expose
    private Integer sID;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("BOOKCATID")
    @Expose
    private Integer bOOKCATID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("BOOKCATNAME")
    @Expose
    private String bOOKCATNAME;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getSID() {
        return sID;
    }

    public void setSID(Integer sID) {
        this.sID = sID;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getBOOKCATID() {
        return bOOKCATID;
    }

    public void setBOOKCATID(Integer bOOKCATID) {
        this.bOOKCATID = bOOKCATID;
    }

    public Integer getENTITYID() {
        return eNTITYID;
    }

    public void setENTITYID(Integer eNTITYID) {
        this.eNTITYID = eNTITYID;
    }

    public Integer getBRANCHID() {
        return bRANCHID;
    }

    public void setBRANCHID(Integer bRANCHID) {
        this.bRANCHID = bRANCHID;
    }

    public String getBOOKCATNAME() {
        return bOOKCATNAME;
    }

    public void setBOOKCATNAME(String bOOKCATNAME) {
        this.bOOKCATNAME = bOOKCATNAME;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}

