package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DesignationInformation {

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
    @SerializedName("DESIGNATIONID")
    @Expose
    private Integer dESIGNATIONID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("DESIGNATIONNAME")
    @Expose
    private String dESIGNATIONNAME;
    @SerializedName("DESIGNATIONALIAS")
    @Expose
    private String dESIGNATIONALIAS;
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

    public Integer getDESIGNATIONID() {
        return dESIGNATIONID;
    }

    public void setDESIGNATIONID(Integer dESIGNATIONID) {
        this.dESIGNATIONID = dESIGNATIONID;
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

    public String getDESIGNATIONNAME() {
        return dESIGNATIONNAME;
    }

    public void setDESIGNATIONNAME(String dESIGNATIONNAME) {
        this.dESIGNATIONNAME = dESIGNATIONNAME;
    }

    public String getDESIGNATIONALIAS() {
        return dESIGNATIONALIAS;
    }

    public void setDESIGNATIONALIAS(String dESIGNATIONALIAS) {
        this.dESIGNATIONALIAS = dESIGNATIONALIAS;
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
