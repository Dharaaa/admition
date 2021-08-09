package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerateMarksheetInformation {
    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("PublishStatus")
    @Expose
    private Boolean publishStatus;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("STUDENTID")
    @Expose
    private String sTUDENTID;
    @SerializedName("STUDENTNO")
    @Expose
    private String sTUDENTNO;
    @SerializedName("STUDENTNAME")
    @Expose
    private String sTUDENTNAME;
    @SerializedName("TOTALMARKS")
    @Expose
    private String tOTALMARKS;
    @SerializedName("OBTAINMARKS")
    @Expose
    private String oBTAINMARKS;
    @SerializedName("MARKSHEETID")
    @Expose
    private String mARKSHEETID;
    @SerializedName("MARKSHEETDETAILID")
    @Expose
    private String mARKSHEETDETAILID;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Boolean getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Boolean publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getSTUDENTID() {
        return sTUDENTID;
    }

    public void setSTUDENTID(String sTUDENTID) {
        this.sTUDENTID = sTUDENTID;
    }

    public String getSTUDENTNO() {
        return sTUDENTNO;
    }

    public void setSTUDENTNO(String sTUDENTNO) {
        this.sTUDENTNO = sTUDENTNO;
    }

    public String getSTUDENTNAME() {
        return sTUDENTNAME;
    }

    public void setSTUDENTNAME(String sTUDENTNAME) {
        this.sTUDENTNAME = sTUDENTNAME;
    }

    public String getTOTALMARKS() {
        return tOTALMARKS;
    }

    public void setTOTALMARKS(String tOTALMARKS) {
        this.tOTALMARKS = tOTALMARKS;
    }

    public String getOBTAINMARKS() {
        return oBTAINMARKS;
    }

    public void setOBTAINMARKS(String oBTAINMARKS) {
        this.oBTAINMARKS = oBTAINMARKS;
    }

    public String getMARKSHEETID() {
        return mARKSHEETID;
    }

    public void setMARKSHEETID(String mARKSHEETID) {
        this.mARKSHEETID = mARKSHEETID;
    }

    public String getMARKSHEETDETAILID() {
        return mARKSHEETDETAILID;
    }

    public void setMARKSHEETDETAILID(String mARKSHEETDETAILID) {
        this.mARKSHEETDETAILID = mARKSHEETDETAILID;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
