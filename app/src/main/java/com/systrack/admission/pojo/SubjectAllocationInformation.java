package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubjectAllocationInformation {


    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("SUBJECTALLOCATIONID")
    @Expose
    private Integer sUBJECTALLOCATIONID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("ACADEMICID")
    @Expose
    private Integer aCADEMICID;
    @SerializedName("BATCHID")
    @Expose
    private Integer bATCHID;
    @SerializedName("COURSEID")
    @Expose
    private Integer cOURSEID;
    @SerializedName("MEDIUM")
    @Expose
    private String mEDIUM;
    @SerializedName("EMPLOYEEID")
    @Expose
    private Integer eMPLOYEEID;
    @SerializedName("SUBJECTID")
    @Expose
    private Integer sUBJECTID;
    @SerializedName("CREATEDBY")
    @Expose
    private Integer cREATEDBY;
    @SerializedName("BATCHNAME")
    @Expose
    private String bATCHNAME;
    @SerializedName("SUBJECTNAME")
    @Expose
    private String sUBJECTNAME;
    @SerializedName("FULLNAME")
    @Expose
    private String fULLNAME;
    @SerializedName("SECTIONID")
    @Expose
    private String sECTIONID;

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

    public Integer getSUBJECTALLOCATIONID() {
        return sUBJECTALLOCATIONID;
    }

    public void setSUBJECTALLOCATIONID(Integer sUBJECTALLOCATIONID) {
        this.sUBJECTALLOCATIONID = sUBJECTALLOCATIONID;
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

    public Integer getCOURSEID() {
        return cOURSEID;
    }

    public void setCOURSEID(Integer cOURSEID) {
        this.cOURSEID = cOURSEID;
    }

    public String getMEDIUM() {
        return mEDIUM;
    }

    public void setMEDIUM(String mEDIUM) {
        this.mEDIUM = mEDIUM;
    }

    public Integer getEMPLOYEEID() {
        return eMPLOYEEID;
    }

    public void setEMPLOYEEID(Integer eMPLOYEEID) {
        this.eMPLOYEEID = eMPLOYEEID;
    }

    public Integer getSUBJECTID() {
        return sUBJECTID;
    }

    public void setSUBJECTID(Integer sUBJECTID) {
        this.sUBJECTID = sUBJECTID;
    }

    public Integer getCREATEDBY() {
        return cREATEDBY;
    }

    public void setCREATEDBY(Integer cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
    }

    public String getBATCHNAME() {
        return bATCHNAME;
    }

    public void setBATCHNAME(String bATCHNAME) {
        this.bATCHNAME = bATCHNAME;
    }

    public String getSUBJECTNAME() {
        return sUBJECTNAME;
    }

    public void setSUBJECTNAME(String sUBJECTNAME) {
        this.sUBJECTNAME = sUBJECTNAME;
    }

    public String getFULLNAME() {
        return fULLNAME;
    }

    public void setFULLNAME(String fULLNAME) {
        this.fULLNAME = fULLNAME;
    }

    public String getSECTIONID() {
        return sECTIONID;
    }

    public void setSECTIONID(String sECTIONID) {
        this.sECTIONID = sECTIONID;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }
}
