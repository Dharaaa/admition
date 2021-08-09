package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClassTimingInformation {

    @SerializedName("TotalCount")
    @Expose
    private int TotalCount;
    @SerializedName("ClassTiming")
    @Expose
    private String ClassTiming;


    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("CLASSTIMINGID")
    @Expose
    private Integer cLASSTIMINGID;
    @SerializedName("BATCHID")
    @Expose
    private Integer bATCHID;
    @SerializedName("SECTIONID")
    @Expose
    private String sECTIONID;
    @SerializedName("NAME")
    @Expose
    private String nAME;
    @SerializedName("STARTTIME")
    @Expose
    private String sTARTTIME;
    @SerializedName("ENDTIME")
    @Expose
    private String eNDTIME;
    @SerializedName("CLASSTIME")
    @Expose
    private String cLASSTIME;
    @SerializedName("ISBREAK")
    @Expose
    private String iSBREAK;
    @SerializedName("ISBREAKCLASS")
    @Expose
    private String iSBREAKCLASS;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("DIVISIONID")
    @Expose
    private Integer dIVISIONID;
    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;
    @SerializedName("CLASSTIMEID")
    @Expose
    private String CLASSTIMEID;

    public String getCLASSTIMEID() {
        return CLASSTIMEID;
    }

    public void setCLASSTIMEID(String CLASSTIMEID) {
        this.CLASSTIMEID = CLASSTIMEID;
    }

    public String getClassTiming() {
        return ClassTiming;
    }

    public void setClassTiming(String classTiming) {
        ClassTiming = classTiming;
    }

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

    public Integer getCLASSTIMINGID() {
        return cLASSTIMINGID;
    }

    public void setCLASSTIMINGID(Integer cLASSTIMINGID) {
        this.cLASSTIMINGID = cLASSTIMINGID;
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

    public String getNAME() {
        return nAME;
    }

    public void setNAME(String nAME) {
        this.nAME = nAME;
    }

    public String getSTARTTIME() {
        return sTARTTIME;
    }

    public void setSTARTTIME(String sTARTTIME) {
        this.sTARTTIME = sTARTTIME;
    }

    public String getENDTIME() {
        return eNDTIME;
    }

    public void setENDTIME(String eNDTIME) {
        this.eNDTIME = eNDTIME;
    }

    public String getCLASSTIME() {
        return cLASSTIME;
    }

    public void setCLASSTIME(String cLASSTIME) {
        this.cLASSTIME = cLASSTIME;
    }

    public String getISBREAK() {
        return iSBREAK;
    }

    public void setISBREAK(String iSBREAK) {
        this.iSBREAK = iSBREAK;
    }

    public String getISBREAKCLASS() {
        return iSBREAKCLASS;
    }

    public void setISBREAKCLASS(String iSBREAKCLASS) {
        this.iSBREAKCLASS = iSBREAKCLASS;
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

    public Integer getDIVISIONID() {
        return dIVISIONID;
    }

    public void setDIVISIONID(Integer dIVISIONID) {
        this.dIVISIONID = dIVISIONID;
    }

    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int totalCount) {
        TotalCount = totalCount;
    }
}
