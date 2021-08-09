package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeContactInformation {
    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("SID")
    @Expose
    private Integer sID;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("EMPLOYEEID")
    @Expose
    private Integer eMPLOYEEID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("EMPLOYEENO")
    @Expose
    private String eMPLOYEENO;
    @SerializedName("DEPARTMENTID")
    @Expose
    private Integer dEPARTMENTID;
    @SerializedName("DESIGNATIONID")
    @Expose
    private Integer dESIGNATIONID;
    @SerializedName("CATEGORYID")
    @Expose
    private Integer cATEGORYID;
    @SerializedName("EMAIL")
    @Expose
    private String eMAIL;
    @SerializedName("MOBILE")
    @Expose
    private String mOBILE;
    @SerializedName("FULLNAME")
    @Expose
    private String fULLNAME;
    @SerializedName("DEPARTMENTNAME")
    @Expose
    private String dEPARTMENTNAME;
    @SerializedName("DESIGNATIONNAME")
    @Expose
    private String dESIGNATIONNAME;
    @SerializedName("CATEGORYNAME")
    @Expose
    private String cATEGORYNAME;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getSID() {
        return sID;
    }

    public void setSID(Integer sID) {
        this.sID = sID;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getEMPLOYEEID() {
        return eMPLOYEEID;
    }

    public void setEMPLOYEEID(Integer eMPLOYEEID) {
        this.eMPLOYEEID = eMPLOYEEID;
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

    public String getEMPLOYEENO() {
        return eMPLOYEENO;
    }

    public void setEMPLOYEENO(String eMPLOYEENO) {
        this.eMPLOYEENO = eMPLOYEENO;
    }

    public Integer getDEPARTMENTID() {
        return dEPARTMENTID;
    }

    public void setDEPARTMENTID(Integer dEPARTMENTID) {
        this.dEPARTMENTID = dEPARTMENTID;
    }

    public Integer getDESIGNATIONID() {
        return dESIGNATIONID;
    }

    public void setDESIGNATIONID(Integer dESIGNATIONID) {
        this.dESIGNATIONID = dESIGNATIONID;
    }

    public Integer getCATEGORYID() {
        return cATEGORYID;
    }

    public void setCATEGORYID(Integer cATEGORYID) {
        this.cATEGORYID = cATEGORYID;
    }

    public String getEMAIL() {
        return eMAIL;
    }

    public void setEMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public String getMOBILE() {
        return mOBILE;
    }

    public void setMOBILE(String mOBILE) {
        this.mOBILE = mOBILE;
    }

    public String getFULLNAME() {
        return fULLNAME;
    }

    public void setFULLNAME(String fULLNAME) {
        this.fULLNAME = fULLNAME;
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

    public String getCATEGORYNAME() {
        return cATEGORYNAME;
    }

    public void setCATEGORYNAME(String cATEGORYNAME) {
        this.cATEGORYNAME = cATEGORYNAME;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }
}
