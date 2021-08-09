package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaveApplicationInformation {


    @SerializedName("DISPLAYDATE")
    @Expose
    private String dISPLAYDATE;
    @SerializedName("WEEKDAY")
    @Expose
    private String wEEKDAY;
    @SerializedName("DISPLAYSTARTTIME")
    @Expose
    private String dISPLAYSTARTTIME;
    @SerializedName("BATCHNAME")
    @Expose
    private String BATCHNAME;
    @SerializedName("SECTIONID")
    @Expose
    private String SECTIONID;
    @SerializedName("SUBJECTNAME")
    @Expose
    private String SUBJECTNAME;
    @SerializedName("EMPROOMLABTYPE")
    @Expose
    private String EMPROOMLABTYPE;
    @SerializedName("EMPFULLNAME")
    @Expose
    private String EMPFULLNAME;
    @SerializedName("SUBNAME")
    @Expose
    private String SUBNAME;
    @SerializedName("DIVISIONNAME")
    @Expose
    private String DIVISIONNAME;


    @SerializedName("DISPLAYSTARTDATE")
    @Expose
    private String dISPLAYSTARTDATE;
    @SerializedName("DISPLAYENDDATE")
    @Expose
    private String dISPLAYENDDATE;


    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("EMPLOYEEID")
    @Expose
    private Integer eMPLOYEEID;
    @SerializedName("LEAVEAPPID")
    @Expose
    private Integer lEAVEAPPID;
    @SerializedName("LEAVEDURATIONID")
    @Expose
    private Integer lEAVEDURATIONID;
    @SerializedName("LEAVETYPEID")
    @Expose
    private Integer lEAVETYPEID;
    @SerializedName("LEAVEAPPLYID")
    @Expose
    private Integer lEAVEAPPLYID;
    @SerializedName("LEAVEDATE")
    @Expose
    private String lEAVEDATE;
    @SerializedName("LEAVESTARTDATE")
    @Expose
    private String lEAVESTARTDATE;
    @SerializedName("LEAVEENDDATE")
    @Expose
    private String lEAVEENDDATE;
    @SerializedName("LEAVEDAYS")
    @Expose
    private Double lEAVEDAYS;
    @SerializedName("FIRSTHALFDAY")
    @Expose
    private Boolean fIRSTHALFDAY;
    @SerializedName("SECONDHALFDAY")
    @Expose
    private Boolean sECONDHALFDAY;
    @SerializedName("REASON")
    @Expose
    private String rEASON;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("EMPNAME")
    @Expose
    private String eMPNAME;
    @SerializedName("EMAIL")
    @Expose
    private String eMAIL;
    @SerializedName("CATEGORYID")
    @Expose
    private Integer cATEGORYID;
    @SerializedName("LEAVESTATUSCLASS")
    @Expose
    private String lEAVESTATUSCLASS;
    @SerializedName("LEAVESTATUS")
    @Expose
    private String lEAVESTATUS;
    @SerializedName("PROCESSBY")
    @Expose
    private Integer pROCESSBY;
    @SerializedName("PROCESSBYNAME")
    @Expose
    private String pROCESSBYNAME;
    @SerializedName("PROCESSDATE")
    @Expose
    private String pROCESSDATE;
    @SerializedName("REMARKS")
    @Expose
    private String rEMARKS;
    @SerializedName("STATUS")
    @Expose
    private String sTATUS;
    @SerializedName("LEAVESTATUSCLASS1")
    @Expose
    private String lEAVESTATUSCLASS1;
    @SerializedName("PROCESSBY1")
    @Expose
    private Object pROCESSBY1;
    @SerializedName("PROCESSBYNAME1")
    @Expose
    private Object pROCESSBYNAME1;
    @SerializedName("PROCESSDATE1")
    @Expose
    private Object pROCESSDATE1;
    @SerializedName("REMARKS1")
    @Expose
    private String rEMARKS1;
    @SerializedName("STATUS1")
    @Expose
    private String sTATUS1;
    @SerializedName("LEAVESTATUSCLASS2")
    @Expose
    private String lEAVESTATUSCLASS2;
    @SerializedName("DURATIONNAME")
    @Expose
    private String dURATIONNAME;
    @SerializedName("LEAVETYPENAME")
    @Expose
    private String lEAVETYPENAME;
    @SerializedName("PRINCIPALID")
    @Expose
    private Integer pRINCIPALID;
    @SerializedName("FIRSTSESSION")
    @Expose
    private Boolean fIRSTSESSION;
    @SerializedName("SECONDSESSION")
    @Expose
    private Boolean sECONDSESSION;
    @SerializedName("COURSEID")
    @Expose
    private Integer cOURSEID;
    @SerializedName("STARTDATE")
    @Expose
    private String sTARTDATE;
    @SerializedName("ENDDATE")
    @Expose
    private String eNDDATE;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getEMPLOYEEID() {
        return eMPLOYEEID;
    }

    public void setEMPLOYEEID(Integer eMPLOYEEID) {
        this.eMPLOYEEID = eMPLOYEEID;
    }

    public Integer getLEAVEAPPID() {
        return lEAVEAPPID;
    }

    public void setLEAVEAPPID(Integer lEAVEAPPID) {
        this.lEAVEAPPID = lEAVEAPPID;
    }

    public Integer getLEAVEDURATIONID() {
        return lEAVEDURATIONID;
    }

    public void setLEAVEDURATIONID(Integer lEAVEDURATIONID) {
        this.lEAVEDURATIONID = lEAVEDURATIONID;
    }

    public Integer getLEAVETYPEID() {
        return lEAVETYPEID;
    }

    public void setLEAVETYPEID(Integer lEAVETYPEID) {
        this.lEAVETYPEID = lEAVETYPEID;
    }

    public Integer getLEAVEAPPLYID() {
        return lEAVEAPPLYID;
    }

    public void setLEAVEAPPLYID(Integer lEAVEAPPLYID) {
        this.lEAVEAPPLYID = lEAVEAPPLYID;
    }

    public String getLEAVEDATE() {
        return lEAVEDATE;
    }

    public void setLEAVEDATE(String lEAVEDATE) {
        this.lEAVEDATE = lEAVEDATE;
    }

    public String getLEAVESTARTDATE() {
        return lEAVESTARTDATE;
    }

    public void setLEAVESTARTDATE(String lEAVESTARTDATE) {
        this.lEAVESTARTDATE = lEAVESTARTDATE;
    }

    public String getLEAVEENDDATE() {
        return lEAVEENDDATE;
    }

    public void setLEAVEENDDATE(String lEAVEENDDATE) {
        this.lEAVEENDDATE = lEAVEENDDATE;
    }

    public Double getLEAVEDAYS() {
        return lEAVEDAYS;
    }

    public void setLEAVEDAYS(Double lEAVEDAYS) {
        this.lEAVEDAYS = lEAVEDAYS;
    }

    public Boolean getFIRSTHALFDAY() {
        return fIRSTHALFDAY;
    }

    public void setFIRSTHALFDAY(Boolean fIRSTHALFDAY) {
        this.fIRSTHALFDAY = fIRSTHALFDAY;
    }

    public Boolean getSECONDHALFDAY() {
        return sECONDHALFDAY;
    }

    public void setSECONDHALFDAY(Boolean sECONDHALFDAY) {
        this.sECONDHALFDAY = sECONDHALFDAY;
    }

    public String getREASON() {
        return rEASON;
    }

    public void setREASON(String rEASON) {
        this.rEASON = rEASON;
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

    public String getEMPNAME() {
        return eMPNAME;
    }

    public void setEMPNAME(String eMPNAME) {
        this.eMPNAME = eMPNAME;
    }

    public String getEMAIL() {
        return eMAIL;
    }

    public void setEMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public Integer getCATEGORYID() {
        return cATEGORYID;
    }

    public void setCATEGORYID(Integer cATEGORYID) {
        this.cATEGORYID = cATEGORYID;
    }

    public String getLEAVESTATUSCLASS() {
        return lEAVESTATUSCLASS;
    }

    public void setLEAVESTATUSCLASS(String lEAVESTATUSCLASS) {
        this.lEAVESTATUSCLASS = lEAVESTATUSCLASS;
    }

    public String getLEAVESTATUS() {
        return lEAVESTATUS;
    }

    public void setLEAVESTATUS(String lEAVESTATUS) {
        this.lEAVESTATUS = lEAVESTATUS;
    }

    public Integer getPROCESSBY() {
        return pROCESSBY;
    }

    public void setPROCESSBY(Integer pROCESSBY) {
        this.pROCESSBY = pROCESSBY;
    }

    public String getPROCESSBYNAME() {
        return pROCESSBYNAME;
    }

    public void setPROCESSBYNAME(String pROCESSBYNAME) {
        this.pROCESSBYNAME = pROCESSBYNAME;
    }

    public String getPROCESSDATE() {
        return pROCESSDATE;
    }

    public void setPROCESSDATE(String pROCESSDATE) {
        this.pROCESSDATE = pROCESSDATE;
    }

    public String getREMARKS() {
        return rEMARKS;
    }

    public void setREMARKS(String rEMARKS) {
        this.rEMARKS = rEMARKS;
    }

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String getLEAVESTATUSCLASS1() {
        return lEAVESTATUSCLASS1;
    }

    public void setLEAVESTATUSCLASS1(String lEAVESTATUSCLASS1) {
        this.lEAVESTATUSCLASS1 = lEAVESTATUSCLASS1;
    }

    public Object getPROCESSBY1() {
        return pROCESSBY1;
    }

    public void setPROCESSBY1(Object pROCESSBY1) {
        this.pROCESSBY1 = pROCESSBY1;
    }

    public Object getPROCESSBYNAME1() {
        return pROCESSBYNAME1;
    }

    public void setPROCESSBYNAME1(Object pROCESSBYNAME1) {
        this.pROCESSBYNAME1 = pROCESSBYNAME1;
    }

    public Object getPROCESSDATE1() {
        return pROCESSDATE1;
    }

    public void setPROCESSDATE1(Object pROCESSDATE1) {
        this.pROCESSDATE1 = pROCESSDATE1;
    }

    public String getREMARKS1() {
        return rEMARKS1;
    }

    public void setREMARKS1(String rEMARKS1) {
        this.rEMARKS1 = rEMARKS1;
    }

public String getSTATUS1() {
        return sTATUS1;
    }

    public void setSTATUS1(String sTATUS1) {
        this.sTATUS1 = sTATUS1;
    }

    public String getLEAVESTATUSCLASS2() {
        return lEAVESTATUSCLASS2;
    }

    public void setLEAVESTATUSCLASS2(String lEAVESTATUSCLASS2) {
        this.lEAVESTATUSCLASS2 = lEAVESTATUSCLASS2;
    }

    public String getDURATIONNAME() {
        return dURATIONNAME;
    }

    public void setDURATIONNAME(String dURATIONNAME) {
        this.dURATIONNAME = dURATIONNAME;
    }

    public String getLEAVETYPENAME() {
        return lEAVETYPENAME;
    }

    public void setLEAVETYPENAME(String lEAVETYPENAME) {
        this.lEAVETYPENAME = lEAVETYPENAME;
    }

    public Integer getPRINCIPALID() {
        return pRINCIPALID;
    }

    public void setPRINCIPALID(Integer pRINCIPALID) {
        this.pRINCIPALID = pRINCIPALID;
    }

    public Boolean getFIRSTSESSION() {
        return fIRSTSESSION;
    }

    public void setFIRSTSESSION(Boolean fIRSTSESSION) {
        this.fIRSTSESSION = fIRSTSESSION;
    }

    public Boolean getSECONDSESSION() {
        return sECONDSESSION;
    }

    public void setSECONDSESSION(Boolean sECONDSESSION) {
        this.sECONDSESSION = sECONDSESSION;
    }

    public Integer getCOURSEID() {
        return cOURSEID;
    }

    public void setCOURSEID(Integer cOURSEID) {
        this.cOURSEID = cOURSEID;
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

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }

    public String getdISPLAYSTARTDATE() {
        return dISPLAYSTARTDATE;
    }

    public void setdISPLAYSTARTDATE(String dISPLAYSTARTDATE) {
        this.dISPLAYSTARTDATE = dISPLAYSTARTDATE;
    }

    public String getdISPLAYENDDATE() {
        return dISPLAYENDDATE;
    }

    public void setdISPLAYENDDATE(String dISPLAYENDDATE) {
        this.dISPLAYENDDATE = dISPLAYENDDATE;
    }

    public String getdISPLAYDATE() {
        return dISPLAYDATE;
    }

    public void setdISPLAYDATE(String dISPLAYDATE) {
        this.dISPLAYDATE = dISPLAYDATE;
    }

    public String getwEEKDAY() {
        return wEEKDAY;
    }

    public void setwEEKDAY(String wEEKDAY) {
        this.wEEKDAY = wEEKDAY;
    }

    public String getdISPLAYSTARTTIME() {
        return dISPLAYSTARTTIME;
    }

    public void setdISPLAYSTARTTIME(String dISPLAYSTARTTIME) {
        this.dISPLAYSTARTTIME = dISPLAYSTARTTIME;
    }

    public String getBATCHNAME() {
        return BATCHNAME;
    }

    public void setBATCHNAME(String BATCHNAME) {
        this.BATCHNAME = BATCHNAME;
    }

    public String getSECTIONID() {
        return SECTIONID;
    }

    public void setSECTIONID(String SECTIONID) {
        this.SECTIONID = SECTIONID;
    }

    public String getSUBJECTNAME() {
        return SUBJECTNAME;
    }

    public void setSUBJECTNAME(String SUBJECTNAME) {
        this.SUBJECTNAME = SUBJECTNAME;
    }

    public String getEMPROOMLABTYPE() {
        return EMPROOMLABTYPE;
    }

    public void setEMPROOMLABTYPE(String EMPROOMLABTYPE) {
        this.EMPROOMLABTYPE = EMPROOMLABTYPE;
    }

    public String getEMPFULLNAME() {
        return EMPFULLNAME;
    }

    public void setEMPFULLNAME(String EMPFULLNAME) {
        this.EMPFULLNAME = EMPFULLNAME;
    }

    public String getSUBNAME() {
        return SUBNAME;
    }

    public void setSUBNAME(String SUBNAME) {
        this.SUBNAME = SUBNAME;
    }

    public String getDIVISIONNAME() {
        return DIVISIONNAME;
    }

    public void setDIVISIONNAME(String DIVISIONNAME) {
        this.DIVISIONNAME = DIVISIONNAME;
    }
}
