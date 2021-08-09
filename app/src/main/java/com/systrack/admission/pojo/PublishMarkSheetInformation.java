package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PublishMarkSheetInformation {


    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;

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
    @SerializedName("ACADEMICID")
    @Expose
    private Integer aCADEMICID;
    @SerializedName("EXAMID")
    @Expose
    private Integer eXAMID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("BATCHID")
    @Expose
    private Integer bATCHID;
    @SerializedName("SECTIONID")
    @Expose
    private String sECTIONID;
    @SerializedName("SECTIONNAME")
    @Expose
    private String sECTIONNAME;
    @SerializedName("PUBLISHDATE")
    @Expose
    private String pUBLISHDATE;
    @SerializedName("EXAMNAME")
    @Expose
    private String eXAMNAME;
    @SerializedName("BATCHNAME")
    @Expose
    private String bATCHNAME;

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

    public Integer getACADEMICID() {
        return aCADEMICID;
    }

    public void setACADEMICID(Integer aCADEMICID) {
        this.aCADEMICID = aCADEMICID;
    }

    public Integer getEXAMID() {
        return eXAMID;
    }

    public void setEXAMID(Integer eXAMID) {
        this.eXAMID = eXAMID;
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

    public String getSECTIONNAME() {
        return sECTIONNAME;
    }

    public void setSECTIONNAME(String sECTIONNAME) {
        this.sECTIONNAME = sECTIONNAME;
    }

    public String getPUBLISHDATE() {
        return pUBLISHDATE;
    }

    public void setPUBLISHDATE(String pUBLISHDATE) {
        this.pUBLISHDATE = pUBLISHDATE;
    }

    public String getEXAMNAME() {
        return eXAMNAME;
    }

    public void setEXAMNAME(String eXAMNAME) {
        this.eXAMNAME = eXAMNAME;
    }

    public String getBATCHNAME() {
        return bATCHNAME;
    }

    public void setBATCHNAME(String bATCHNAME) {
        this.bATCHNAME = bATCHNAME;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }
}
