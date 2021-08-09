package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaveAssignInformation {


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
    @SerializedName("ASSIGNID")
    @Expose
    private Integer aSSIGNID;
    @SerializedName("LEAVEDURATIONID")
    @Expose
    private Integer lEAVEDURATIONID;
    @SerializedName("DEPARTMENTID")
    @Expose
    private Integer dEPARTMENTID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("EMPID")
    @Expose
    private Integer eMPID;
    @SerializedName("LEAVETYPE")
    @Expose
    private String lEAVETYPE;
    @SerializedName("TOTALDAYS")
    @Expose
    private String tOTALDAYS;
    @SerializedName("COURSEID")
    @Expose
    private Integer cOURSEID;
    @SerializedName("FULLNAME")
    @Expose
    private String fULLNAME;
    @SerializedName("EMPLOYEENO")
    @Expose
    private String eMPLOYEENO;
    @SerializedName("MOBILE")
    @Expose
    private String mOBILE;
    @SerializedName("EMAIL")
    @Expose
    private String eMAIL;
    @SerializedName("GENDER")
    @Expose
    private String gENDER;
    @SerializedName("MEDIUM")
    @Expose
    private String mEDIUM;
    @SerializedName("DEPARTMENTNAME")
    @Expose
    private String dEPARTMENTNAME;
    @SerializedName("DESIGNATIONNAME")
    @Expose
    private String dESIGNATIONNAME;
    @SerializedName("DURATIONNAME")
    @Expose
    private String dURATIONNAME;
    @SerializedName("STARTDATE")
    @Expose
    private String sTARTDATE;
    @SerializedName("ENDDATE")
    @Expose
    private String eNDDATE;
    @SerializedName("YEARCOUNT")
    @Expose
    private Integer yEARCOUNT;

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

    public Integer getASSIGNID() {
        return aSSIGNID;
    }

    public void setASSIGNID(Integer aSSIGNID) {
        this.aSSIGNID = aSSIGNID;
    }

    public Integer getLEAVEDURATIONID() {
        return lEAVEDURATIONID;
    }

    public void setLEAVEDURATIONID(Integer lEAVEDURATIONID) {
        this.lEAVEDURATIONID = lEAVEDURATIONID;
    }

    public Integer getDEPARTMENTID() {
        return dEPARTMENTID;
    }

    public void setDEPARTMENTID(Integer dEPARTMENTID) {
        this.dEPARTMENTID = dEPARTMENTID;
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

    public Integer getEMPID() {
        return eMPID;
    }

    public void setEMPID(Integer eMPID) {
        this.eMPID = eMPID;
    }

    public String getLEAVETYPE() {
        return lEAVETYPE;
    }

    public void setLEAVETYPE(String lEAVETYPE) {
        this.lEAVETYPE = lEAVETYPE;
    }

    public String getTOTALDAYS() {
        return tOTALDAYS;
    }

    public void setTOTALDAYS(String tOTALDAYS) {
        this.tOTALDAYS = tOTALDAYS;
    }

    public Integer getCOURSEID() {
        return cOURSEID;
    }

    public void setCOURSEID(Integer cOURSEID) {
        this.cOURSEID = cOURSEID;
    }

    public String getFULLNAME() {
        return fULLNAME;
    }

    public void setFULLNAME(String fULLNAME) {
        this.fULLNAME = fULLNAME;
    }

    public String getEMPLOYEENO() {
        return eMPLOYEENO;
    }

    public void setEMPLOYEENO(String eMPLOYEENO) {
        this.eMPLOYEENO = eMPLOYEENO;
    }

    public String getMOBILE() {
        return mOBILE;
    }

    public void setMOBILE(String mOBILE) {
        this.mOBILE = mOBILE;
    }

    public String getEMAIL() {
        return eMAIL;
    }

    public void setEMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public String getGENDER() {
        return gENDER;
    }

    public void setGENDER(String gENDER) {
        this.gENDER = gENDER;
    }

    public String getMEDIUM() {
        return mEDIUM;
    }

    public void setMEDIUM(String mEDIUM) {
        this.mEDIUM = mEDIUM;
    }

    public String getDEPARTMENTNAME() {
        return dEPARTMENTNAME;
    }

    public void setDEPARTMENTNAME(String dEPARTMENTNAME) {
        this.dEPARTMENTNAME = dEPARTMENTNAME;
    }

    public String getDESIGNATIONNAME() {
        return dESIGNATIONNAME;
    }

    public void setDESIGNATIONNAME(String dESIGNATIONNAME) {
        this.dESIGNATIONNAME = dESIGNATIONNAME;
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

    public Integer getYEARCOUNT() {
        return yEARCOUNT;
    }

    public void setYEARCOUNT(Integer yEARCOUNT) {
        this.yEARCOUNT = yEARCOUNT;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }
}

