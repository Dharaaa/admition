package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClassDivisionInformation {

    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;
    @SerializedName("COURSENAME")
    @Expose
    private String cOURSENAME;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("DIVISIONID")
    @Expose
    private Integer dIVISIONID;
    @SerializedName("DIVISIONNAME")
    @Expose
    private String dIVISIONNAME;
    @SerializedName("DIVISIONALIAS")
    @Expose
    private String dIVISIONALIAS;
    @SerializedName("ACADEMICID")
    @Expose
    private Integer aCADEMICID;
    @SerializedName("BATCHID")
    @Expose
    private Integer bATCHID;
    @SerializedName("SECTIONID")
    @Expose
    private String sECTIONID;
    @SerializedName("SECTIONNAME")
    @Expose
    private String sECTIONNAME;
    @SerializedName("CREADBY")
    @Expose
    private Integer cREADBY;
    @SerializedName("CREATEDDATETIME")
    @Expose
    private String cREATEDDATETIME;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("MEDIUM")
    @Expose
    private String mEDIUM;
    @SerializedName("COURSEID")
    @Expose
    private Integer cOURSEID;
    @SerializedName("BATCHNAME")
    @Expose
    private String bATCHNAME;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getDIVISIONID() {
        return dIVISIONID;
    }

    public void setDIVISIONID(Integer dIVISIONID) {
        this.dIVISIONID = dIVISIONID;
    }

    public String getDIVISIONNAME() {
        return dIVISIONNAME;
    }

    public void setDIVISIONNAME(String dIVISIONNAME) {
        this.dIVISIONNAME = dIVISIONNAME;
    }

    public String getDIVISIONALIAS() {
        return dIVISIONALIAS;
    }

    public void setDIVISIONALIAS(String dIVISIONALIAS) {
        this.dIVISIONALIAS = dIVISIONALIAS;
    }

    public Integer getACADEMICID() {
        return aCADEMICID;
    }

    public void setACADEMICID(Integer aCADEMICID) {
        this.aCADEMICID = aCADEMICID;
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

    public Integer getCREADBY() {
        return cREADBY;
    }

    public void setCREADBY(Integer cREADBY) {
        this.cREADBY = cREADBY;
    }

    public String getCREATEDDATETIME() {
        return cREATEDDATETIME;
    }

    public void setCREATEDDATETIME(String cREATEDDATETIME) {
        this.cREATEDDATETIME = cREATEDDATETIME;
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

    public String getMEDIUM() {
        return mEDIUM;
    }

    public void setMEDIUM(String mEDIUM) {
        this.mEDIUM = mEDIUM;
    }

    public Integer getCOURSEID() {
        return cOURSEID;
    }

    public void setCOURSEID(Integer cOURSEID) {
        this.cOURSEID = cOURSEID;
    }

    public String getBATCHNAME() {
        return bATCHNAME;
    }

    public void setBATCHNAME(String bATCHNAME) {
        this.bATCHNAME = bATCHNAME;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getcOURSENAME() {
        return cOURSENAME;
    }

    public void setcOURSENAME(String cOURSENAME) {
        this.cOURSENAME = cOURSENAME;
    }
}
