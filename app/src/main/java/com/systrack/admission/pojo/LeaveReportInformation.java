package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaveReportInformation {


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
    @SerializedName("REPORTINGID")
    @Expose
    private Integer rEPORTINGID;
    @SerializedName("DEPARTMENTID")
    @Expose
    private Integer dEPARTMENTID;
    @SerializedName("REPORTINGEMPID")
    @Expose
    private Integer rEPORTINGEMPID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("EMPID")
    @Expose
    private Integer eMPID;
    @SerializedName("FULLNAME")
    @Expose
    private String fULLNAME;
    @SerializedName("COURSEID")
    @Expose
    private Integer cOURSEID;
    @SerializedName("EMPLOYEENO")
    @Expose
    private String eMPLOYEENO;
    @SerializedName("REPORTINGEMPNAME")
    @Expose
    private String rEPORTINGEMPNAME;
    @SerializedName("DESIGNATIONNAME")
    @Expose
    private String dESIGNATIONNAME;
    @SerializedName("REPORTINGEMAIL")
    @Expose
    private String rEPORTINGEMAIL;
    @SerializedName("MOBILE")
    @Expose
    private String mOBILE;
    @SerializedName("MANAGERDESID")
    @Expose
    private Integer mANAGERDESID;
    @SerializedName("MANAGERDESNAME")
    @Expose
    private String mANAGERDESNAME;

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

    public Integer getREPORTINGID() {
        return rEPORTINGID;
    }

    public void setREPORTINGID(Integer rEPORTINGID) {
        this.rEPORTINGID = rEPORTINGID;
    }

    public Integer getDEPARTMENTID() {
        return dEPARTMENTID;
    }

    public void setDEPARTMENTID(Integer dEPARTMENTID) {
        this.dEPARTMENTID = dEPARTMENTID;
    }

    public Integer getREPORTINGEMPID() {
        return rEPORTINGEMPID;
    }

    public void setREPORTINGEMPID(Integer rEPORTINGEMPID) {
        this.rEPORTINGEMPID = rEPORTINGEMPID;
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

    public String getEMPLOYEENO() {
        return eMPLOYEENO;
    }

    public void setEMPLOYEENO(String eMPLOYEENO) {
        this.eMPLOYEENO = eMPLOYEENO;
    }

    public String getREPORTINGEMPNAME() {
        return rEPORTINGEMPNAME;
    }

    public void setREPORTINGEMPNAME(String rEPORTINGEMPNAME) {
        this.rEPORTINGEMPNAME = rEPORTINGEMPNAME;
    }

    public String getDESIGNATIONNAME() {
        return dESIGNATIONNAME;
    }

    public void setDESIGNATIONNAME(String dESIGNATIONNAME) {
        this.dESIGNATIONNAME = dESIGNATIONNAME;
    }

    public String getREPORTINGEMAIL() {
        return rEPORTINGEMAIL;
    }

    public void setREPORTINGEMAIL(String rEPORTINGEMAIL) {
        this.rEPORTINGEMAIL = rEPORTINGEMAIL;
    }

    public String getMOBILE() {
        return mOBILE;
    }

    public void setMOBILE(String mOBILE) {
        this.mOBILE = mOBILE;
    }

    public Integer getMANAGERDESID() {
        return mANAGERDESID;
    }

    public void setMANAGERDESID(Integer mANAGERDESID) {
        this.mANAGERDESID = mANAGERDESID;
    }

    public String getMANAGERDESNAME() {
        return mANAGERDESNAME;
    }

    public void setMANAGERDESNAME(String mANAGERDESNAME) {
        this.mANAGERDESNAME = mANAGERDESNAME;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}

