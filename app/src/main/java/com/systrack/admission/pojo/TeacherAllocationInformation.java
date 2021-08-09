package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeacherAllocationInformation {


    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("SECTIONALLOCATIONID")
    @Expose
    private Integer sECTIONALLOCATIONID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("SECTIONID")
    @Expose
    private String sECTIONID;
    @SerializedName("EMPLOYEEID")
    @Expose
    private Integer eMPLOYEEID;
    @SerializedName("ISCLASSTEACHER")
    @Expose
    private Boolean iSCLASSTEACHER;
    @SerializedName("ISCLASSTEACHERVALUE")
    @Expose
    private String iSCLASSTEACHERVALUE;
    @SerializedName("ACADEMICID")
    @Expose
    private Integer aCADEMICID;
    @SerializedName("BATCHID")
    @Expose
    private Integer bATCHID;
    @SerializedName("CREATEDBY")
    @Expose
    private Integer cREATEDBY;
    @SerializedName("COURSEID")
    @Expose
    private Integer cOURSEID;
    @SerializedName("MEDIUM")
    @Expose
    private String mEDIUM;
    @SerializedName("EMPLOYEEID1")
    @Expose
    private Integer eMPLOYEEID1;
    @SerializedName("FULLNAME")
    @Expose
    private String fULLNAME;
    @SerializedName("EMPSTATUS")
    @Expose
    private Boolean eMPSTATUS;

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

    public Integer getSECTIONALLOCATIONID() {
        return sECTIONALLOCATIONID;
    }

    public void setSECTIONALLOCATIONID(Integer sECTIONALLOCATIONID) {
        this.sECTIONALLOCATIONID = sECTIONALLOCATIONID;
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

    public String getSECTIONID() {
        return sECTIONID;
    }

    public void setSECTIONID(String sECTIONID) {
        this.sECTIONID = sECTIONID;
    }

    public Integer getEMPLOYEEID() {
        return eMPLOYEEID;
    }

    public void setEMPLOYEEID(Integer eMPLOYEEID) {
        this.eMPLOYEEID = eMPLOYEEID;
    }

    public Boolean getISCLASSTEACHER() {
        return iSCLASSTEACHER;
    }

    public void setISCLASSTEACHER(Boolean iSCLASSTEACHER) {
        this.iSCLASSTEACHER = iSCLASSTEACHER;
    }

    public String getISCLASSTEACHERVALUE() {
        return iSCLASSTEACHERVALUE;
    }

    public void setISCLASSTEACHERVALUE(String iSCLASSTEACHERVALUE) {
        this.iSCLASSTEACHERVALUE = iSCLASSTEACHERVALUE;
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

    public Integer getCREATEDBY() {
        return cREATEDBY;
    }

    public void setCREATEDBY(Integer cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
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

    public Integer getEMPLOYEEID1() {
        return eMPLOYEEID1;
    }

    public void setEMPLOYEEID1(Integer eMPLOYEEID1) {
        this.eMPLOYEEID1 = eMPLOYEEID1;
    }

    public String getFULLNAME() {
        return fULLNAME;
    }

    public void setFULLNAME(String fULLNAME) {
        this.fULLNAME = fULLNAME;
    }

    public Boolean getEMPSTATUS() {
        return eMPSTATUS;
    }

    public void setEMPSTATUS(Boolean eMPSTATUS) {
        this.eMPSTATUS = eMPSTATUS;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
