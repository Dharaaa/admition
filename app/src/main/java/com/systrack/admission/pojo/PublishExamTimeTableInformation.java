package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublishExamTimeTableInformation {


    @SerializedName("EXAMTIME")
    @Expose
    private String eXAMTIME;
    @SerializedName("DISPLAYEXAMDATE")
    @Expose
    private String dISPLAYEXAMDATE;
    @SerializedName("HALLNO")
    @Expose
    private String hALLNO;
    @SerializedName("SUBJECTNAME")
    @Expose
    private String sUBJECTNAME;

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
    @SerializedName("PUBLISHID")
    @Expose
    private Integer pUBLISHID;
    @SerializedName("EXAMNAME")
    @Expose
    private String eXAMNAME;
    @SerializedName("MINDATE")
    @Expose
    private String mINDATE;
    @SerializedName("MAXDATE")
    @Expose
    private String mAXDATE;
    @SerializedName("DISPLAYPUBLISHDATE")
    @Expose
    private String dISPLAYPUBLISHDATE;
    @SerializedName("PUBLISHDATE")
    @Expose
    private String pUBLISHDATE;
    @SerializedName("BATCHNAME")
    @Expose
    private String bATCHNAME;
    @SerializedName("SECTIONNAME")
    @Expose
    private String sECTIONNAME;
    @SerializedName("TIMETABLEID")
    @Expose
    private Integer tIMETABLEID;
    @SerializedName("BATCHID")
    @Expose
    private Integer bATCHID;
    @SerializedName("SECTIONID")
    @Expose
    private String sECTIONID;
    @SerializedName("ISVIEWMARKSHEET")
    @Expose
    private String iSVIEWMARKSHEET;

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

    public Integer getPUBLISHID() {
        return pUBLISHID;
    }

    public void setPUBLISHID(Integer pUBLISHID) {
        this.pUBLISHID = pUBLISHID;
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

    public String getDISPLAYPUBLISHDATE() {
        return dISPLAYPUBLISHDATE;
    }

    public void setDISPLAYPUBLISHDATE(String dISPLAYPUBLISHDATE) {
        this.dISPLAYPUBLISHDATE = dISPLAYPUBLISHDATE;
    }

    public String getPUBLISHDATE() {
        return pUBLISHDATE;
    }

    public void setPUBLISHDATE(String pUBLISHDATE) {
        this.pUBLISHDATE = pUBLISHDATE;
    }

    public String getBATCHNAME() {
        return bATCHNAME;
    }

    public void setBATCHNAME(String bATCHNAME) {
        this.bATCHNAME = bATCHNAME;
    }

    public String getSECTIONNAME() {
        return sECTIONNAME;
    }

    public void setSECTIONNAME(String sECTIONNAME) {
        this.sECTIONNAME = sECTIONNAME;
    }

    public Integer getTIMETABLEID() {
        return tIMETABLEID;
    }

    public void setTIMETABLEID(Integer tIMETABLEID) {
        this.tIMETABLEID = tIMETABLEID;
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

    public void setSECTIONID(String sECTIONID) {
        this.sECTIONID = sECTIONID;
    }

    public String getISVIEWMARKSHEET() {
        return iSVIEWMARKSHEET;
    }

    public void setISVIEWMARKSHEET(String iSVIEWMARKSHEET) {
        this.iSVIEWMARKSHEET = iSVIEWMARKSHEET;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String geteXAMTIME() {
        return eXAMTIME;
    }

    public void seteXAMTIME(String eXAMTIME) {
        this.eXAMTIME = eXAMTIME;
    }

    public String getdISPLAYEXAMDATE() {
        return dISPLAYEXAMDATE;
    }

    public void setdISPLAYEXAMDATE(String dISPLAYEXAMDATE) {
        this.dISPLAYEXAMDATE = dISPLAYEXAMDATE;
    }

    public String gethALLNO() {
        return hALLNO;
    }

    public void sethALLNO(String hALLNO) {
        this.hALLNO = hALLNO;
    }

    public String getsUBJECTNAME() {
        return sUBJECTNAME;
    }

    public void setsUBJECTNAME(String sUBJECTNAME) {
        this.sUBJECTNAME = sUBJECTNAME;
    }
}

