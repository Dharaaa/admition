package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModeratorAffiliationInformation {


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
    @SerializedName("AFFILIATIONID")
    @Expose
    private Integer aFFILIATIONID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("ACADEMICID")
    @Expose
    private Integer aCADEMICID;
    @SerializedName("EXAMID")
    @Expose
    private Integer eXAMID;
    @SerializedName("BATCHID")
    @Expose
    private Integer bATCHID;
    @SerializedName("SECTIONID")
    @Expose
    private String sECTIONID;
    @SerializedName("DIVISIONID")
    @Expose
    private Integer dIVISIONID;
    @SerializedName("SUBJECTID")
    @Expose
    private Integer sUBJECTID;
    @SerializedName("EMPLOYEEID")
    @Expose
    private String eMPLOYEEID;
    @SerializedName("SUBJECTNAME")
    @Expose
    private String sUBJECTNAME;
    @SerializedName("Id")
    @Expose
    private Object id;
    @SerializedName("EMPLOYEENAME")
    @Expose
    private String eMPLOYEENAME;

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

    public Integer getAFFILIATIONID() {
        return aFFILIATIONID;
    }

    public void setAFFILIATIONID(Integer aFFILIATIONID) {
        this.aFFILIATIONID = aFFILIATIONID;
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

    public Integer getEXAMID() {
        return eXAMID;
    }

    public void setEXAMID(Integer eXAMID) {
        this.eXAMID = eXAMID;
    }

    public Integer getBATCHID() {
        return bATCHID;
    }

    public void setBATCHID(Integer bATCHID) {
        this.bATCHID = bATCHID;
    }

    public String getSECTIONID() {
        return sECTIONID;
    }

    public void setSECTIONID(String sECTIONID) {
        this.sECTIONID = sECTIONID;
    }

    public Integer getDIVISIONID() {
        return dIVISIONID;
    }

    public void setDIVISIONID(Integer dIVISIONID) {
        this.dIVISIONID = dIVISIONID;
    }

    public Integer getSUBJECTID() {
        return sUBJECTID;
    }

    public void setSUBJECTID(Integer sUBJECTID) {
        this.sUBJECTID = sUBJECTID;
    }

    public String getEMPLOYEEID() {
        return eMPLOYEEID;
    }

    public void setEMPLOYEEID(String eMPLOYEEID) {
        this.eMPLOYEEID = eMPLOYEEID;
    }

    public String getSUBJECTNAME() {
        return sUBJECTNAME;
    }

    public void setSUBJECTNAME(String sUBJECTNAME) {
        this.sUBJECTNAME = sUBJECTNAME;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getEMPLOYEENAME() {
        return eMPLOYEENAME;
    }

    public void setEMPLOYEENAME(String eMPLOYEENAME) {
        this.eMPLOYEENAME = eMPLOYEENAME;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
