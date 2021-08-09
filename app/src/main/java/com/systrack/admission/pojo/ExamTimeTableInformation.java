package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExamTimeTableInformation {
    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;


    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("ROWNUM")
    @Expose
    private Integer rOWNUM;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("EXAMNAME")
    @Expose
    private String eXAMNAME;
    @SerializedName("MINDATE")
    @Expose
    private String mINDATE;
    @SerializedName("MAXDATE")
    @Expose
    private String mAXDATE;
    @SerializedName("TIMETABLEID")
    @Expose
    private Integer tIMETABLEID;
    @SerializedName("EXAMID")
    @Expose
    private Integer eXAMID;
    @SerializedName("BATCHID")
    @Expose
    private Integer bATCHID;
    @SerializedName("SECTIONID")
    @Expose
    private String sECTIONID;
    @SerializedName("COURSEID")
    @Expose
    private Integer cOURSEID;
    @SerializedName("MEDIUM")
    @Expose
    private String mEDIUM;

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

    public String getEXAMNAME() {
        return eXAMNAME;
    }

    public void setEXAMNAME(String eXAMNAME) {
        this.eXAMNAME = eXAMNAME;
    }

    public String getMINDATE() {
        return mINDATE;
    }

    public void setMINDATE(String mINDATE) {
        this.mINDATE = mINDATE;
    }

    public String getMAXDATE() {
        return mAXDATE;
    }

    public void setMAXDATE(String mAXDATE) {
        this.mAXDATE = mAXDATE;
    }

    public Integer getTIMETABLEID() {
        return tIMETABLEID;
    }

    public void setTIMETABLEID(Integer tIMETABLEID) {
        this.tIMETABLEID = tIMETABLEID;
    }

    public Integer getEXAMID() {
        return eXAMID;
    }

    public void setEXAMID(Integer eXAMID) {
        this.eXAMID = eXAMID;
    }

    public Integer getBATCHID() {
        return bATCHID;
    }

    public void setBATCHID(Integer bATCHID) {
        this.bATCHID = bATCHID;
    }

    public String getSECTIONID() {
        return sECTIONID;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public void setSECTIONID(String sECTIONID) {
        this.sECTIONID = sECTIONID;
    }

    public Integer getCOURSEID() {
        return cOURSEID;
    }

    public void setCOURSEID(Integer cOURSEID) {
        this.cOURSEID = cOURSEID;
    }

    public String getMEDIUM() {
        return mEDIUM;
    }

    public void setMEDIUM(String mEDIUM) {
        this.mEDIUM = mEDIUM;
    }


}
