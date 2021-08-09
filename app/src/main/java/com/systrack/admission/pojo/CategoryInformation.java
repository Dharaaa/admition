package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryInformation {

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
    @SerializedName("CATEGORYID")
    @Expose
    private Integer cATEGORYID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("CATEGORYNAME")
    @Expose
    private String cATEGORYNAME;
    @SerializedName("CATEGORYALIAS")
    @Expose
    private String cATEGORYALIAS;
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

    public Integer getCATEGORYID() {
        return cATEGORYID;
    }

    public void setCATEGORYID(Integer cATEGORYID) {
        this.cATEGORYID = cATEGORYID;
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

    public String getCATEGORYNAME() {
        return cATEGORYNAME;
    }

    public void setCATEGORYNAME(String cATEGORYNAME) {
        this.cATEGORYNAME = cATEGORYNAME;
    }

    public String getCATEGORYALIAS() {
        return cATEGORYALIAS;
    }

    public void setCATEGORYALIAS(String cATEGORYALIAS) {
        this.cATEGORYALIAS = cATEGORYALIAS;
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
