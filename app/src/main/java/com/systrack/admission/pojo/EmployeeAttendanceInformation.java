package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeAttendanceInformation {


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
    @SerializedName("ATTENDANCEID")
    @Expose
    private Integer aTTENDANCEID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("DEPARTMENTID")
    @Expose
    private Integer dEPARTMENTID;
    @SerializedName("ATTDATE")
    @Expose
    private String aTTDATE;
    @SerializedName("MONTHYEARDATE")
    @Expose
    private String mONTHYEARDATE;
    @SerializedName("EMPATTDATE")
    @Expose
    private String eMPATTDATE;
    @SerializedName("EMPLOYEEID")
    @Expose
    private Integer eMPLOYEEID;
    @SerializedName("PRESENTREMARK")
    @Expose
    private String pRESENTREMARK;
    @SerializedName("EMPABSENTID")
    @Expose
    private Object eMPABSENTID;
    @SerializedName("DATE")
    @Expose
    private Object dATE;
    @SerializedName("HALFDAY")
    @Expose
    private Object hALFDAY;
    @SerializedName("ABSENTREMARK")
    @Expose
    private String aBSENTREMARK;
    @SerializedName("CREATEDBY")
    @Expose
    private Object cREATEDBY;
    @SerializedName("ATTENDANCEMASTERID")
    @Expose
    private Object aTTENDANCEMASTERID;
    @SerializedName("EMPLOYEENO")
    @Expose
    private String eMPLOYEENO;
    @SerializedName("FULLNAME")
    @Expose
    private String fULLNAME;
    @SerializedName("COURSEID")
    @Expose
    private Integer cOURSEID;

    @SerializedName("DATEARRAY")
    @Expose
    private String DATEARRAY;


    public String getDATEARRAY() {
        return DATEARRAY;
    }

    public void setDATEARRAY(String DATEARRAY) {
        this.DATEARRAY = DATEARRAY;
    }

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

    public Integer getATTENDANCEID() {
        return aTTENDANCEID;
    }

    public void setATTENDANCEID(Integer aTTENDANCEID) {
        this.aTTENDANCEID = aTTENDANCEID;
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

    public Integer getDEPARTMENTID() {
        return dEPARTMENTID;
    }

    public void setDEPARTMENTID(Integer dEPARTMENTID) {
        this.dEPARTMENTID = dEPARTMENTID;
    }

    public String getATTDATE() {
        return aTTDATE;
    }

    public void setATTDATE(String aTTDATE) {
        this.aTTDATE = aTTDATE;
    }

    public String getMONTHYEARDATE() {
        return mONTHYEARDATE;
    }

    public void setMONTHYEARDATE(String mONTHYEARDATE) {
        this.mONTHYEARDATE = mONTHYEARDATE;
    }

    public String getEMPATTDATE() {
        return eMPATTDATE;
    }

    public void setEMPATTDATE(String eMPATTDATE) {
        this.eMPATTDATE = eMPATTDATE;
    }

    public Integer getEMPLOYEEID() {
        return eMPLOYEEID;
    }

    public void setEMPLOYEEID(Integer eMPLOYEEID) {
        this.eMPLOYEEID = eMPLOYEEID;
    }

    public String getPRESENTREMARK() {
        return pRESENTREMARK;
    }

    public void setPRESENTREMARK(String pRESENTREMARK) {
        this.pRESENTREMARK = pRESENTREMARK;
    }

    public Object getEMPABSENTID() {
        return eMPABSENTID;
    }

    public void setEMPABSENTID(Object eMPABSENTID) {
        this.eMPABSENTID = eMPABSENTID;
    }

    public Object getDATE() {
        return dATE;
    }

    public void setDATE(Object dATE) {
        this.dATE = dATE;
    }

    public Object getHALFDAY() {
        return hALFDAY;
    }

    public void setHALFDAY(Object hALFDAY) {
        this.hALFDAY = hALFDAY;
    }

    public String getABSENTREMARK() {
        return aBSENTREMARK;
    }

    public void setABSENTREMARK(String aBSENTREMARK) {
        this.aBSENTREMARK = aBSENTREMARK;
    }

    public Object getCREATEDBY() {
        return cREATEDBY;
    }

    public void setCREATEDBY(Object cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
    }

    public Object getATTENDANCEMASTERID() {
        return aTTENDANCEMASTERID;
    }

    public void setATTENDANCEMASTERID(Object aTTENDANCEMASTERID) {
        this.aTTENDANCEMASTERID = aTTENDANCEMASTERID;
    }

    public String getEMPLOYEENO() {
        return eMPLOYEENO;
    }

    public void setEMPLOYEENO(String eMPLOYEENO) {
        this.eMPLOYEENO = eMPLOYEENO;
    }

    public String getFULLNAME() {
        return fULLNAME;
    }

    public void setFULLNAME(String fULLNAME) {
        this.fULLNAME = fULLNAME;
    }

    public Integer getCOURSEID() {
        return cOURSEID;
    }

    public void setCOURSEID(Integer cOURSEID) {
        this.cOURSEID = cOURSEID;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;

    }
}
