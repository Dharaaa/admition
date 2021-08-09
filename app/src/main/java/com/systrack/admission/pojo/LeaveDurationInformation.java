package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaveDurationInformation {

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("ROWNUM")
    @Expose
    private Integer rOWNUM;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("LEAVEDURATIONID")
    @Expose
    private Integer lEAVEDURATIONID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("DURATIONNAME")
    @Expose
    private String dURATIONNAME;
    @SerializedName("STARTDATE")
    @Expose
    private String sTARTDATE;
    @SerializedName("ENDDATE")
    @Expose
    private String eNDDATE;
    @SerializedName("STARTDATES")
    @Expose
    private String sTARTDATES;
    @SerializedName("ENDDATES")
    @Expose
    private String eNDDATES;
    @SerializedName("DISPLAYSTARTDATE")
    @Expose
    private String dISPLAYSTARTDATE;
    @SerializedName("DISPLAYENDDATE")
    @Expose
    private String dISPLAYENDDATE;
    @SerializedName("STATUS")
    @Expose
    private Boolean sTATUS;
    @SerializedName("LEAVESTATUS")
    @Expose
    private String lEAVESTATUS;
    @SerializedName("LEAVESTATUSCLASS")
    @Expose
    private String lEAVESTATUSCLASS;
    @SerializedName("StatusChangeFlag")
    @Expose
    private String statusChangeFlag;
    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getROWNUM() {
        return rOWNUM;
    }

    public void setROWNUM(Integer rOWNUM) {
        this.rOWNUM = rOWNUM;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getLEAVEDURATIONID() {
        return lEAVEDURATIONID;
    }

    public void setLEAVEDURATIONID(Integer lEAVEDURATIONID) {
        this.lEAVEDURATIONID = lEAVEDURATIONID;
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

    public String getDURATIONNAME() {
        return dURATIONNAME;
    }

    public void setDURATIONNAME(String dURATIONNAME) {
        this.dURATIONNAME = dURATIONNAME;
    }

    public String getSTARTDATE() {
        return sTARTDATE;
    }

    public void setSTARTDATE(String sTARTDATE) {
        this.sTARTDATE = sTARTDATE;
    }

    public String getENDDATE() {
        return eNDDATE;
    }

    public void setENDDATE(String eNDDATE) {
        this.eNDDATE = eNDDATE;
    }

    public String getSTARTDATES() {
        return sTARTDATES;
    }

    public void setSTARTDATES(String sTARTDATES) {
        this.sTARTDATES = sTARTDATES;
    }

    public String getENDDATES() {
        return eNDDATES;
    }

    public void setENDDATES(String eNDDATES) {
        this.eNDDATES = eNDDATES;
    }

    public String getDISPLAYSTARTDATE() {
        return dISPLAYSTARTDATE;
    }

    public void setDISPLAYSTARTDATE(String dISPLAYSTARTDATE) {
        this.dISPLAYSTARTDATE = dISPLAYSTARTDATE;
    }

    public String getDISPLAYENDDATE() {
        return dISPLAYENDDATE;
    }

    public void setDISPLAYENDDATE(String dISPLAYENDDATE) {
        this.dISPLAYENDDATE = dISPLAYENDDATE;
    }

    public Boolean getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(Boolean sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String getLEAVESTATUS() {
        return lEAVESTATUS;
    }

    public void setLEAVESTATUS(String lEAVESTATUS) {
        this.lEAVESTATUS = lEAVESTATUS;
    }

    public String getLEAVESTATUSCLASS() {
        return lEAVESTATUSCLASS;
    }

    public void setLEAVESTATUSCLASS(String lEAVESTATUSCLASS) {
        this.lEAVESTATUSCLASS = lEAVESTATUSCLASS;
    }

    public String getStatusChangeFlag() {
        return statusChangeFlag;
    }

    public void setStatusChangeFlag(String statusChangeFlag) {
        this.statusChangeFlag = statusChangeFlag;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }
}
