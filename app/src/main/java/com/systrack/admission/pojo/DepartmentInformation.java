package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepartmentInformation {

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
    @SerializedName("DEPARTMENTID")
    @Expose
    private Integer dEPARTMENTID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("DEPARTMENTNAME")
    @Expose
    private String dEPARTMENTNAME;
    @SerializedName("DEPARTMENTALIAS")
    @Expose
    private String dEPARTMENTALIAS;
    @SerializedName("ISGLOBAL")
    @Expose
    private Boolean iSGLOBAL;

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

    public String getDEPARTMENTNAME() {
        return dEPARTMENTNAME;
    }

    public void setDEPARTMENTNAME(String dEPARTMENTNAME) {
        this.dEPARTMENTNAME = dEPARTMENTNAME;
    }

    public String getDEPARTMENTALIAS() {
        return dEPARTMENTALIAS;
    }

    public void setDEPARTMENTALIAS(String dEPARTMENTALIAS) {
        this.dEPARTMENTALIAS = dEPARTMENTALIAS;
    }

    public Boolean getISGLOBAL() {
        return iSGLOBAL;
    }

    public void setISGLOBAL(Boolean iSGLOBAL) {
        this.iSGLOBAL = iSGLOBAL;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }
}
