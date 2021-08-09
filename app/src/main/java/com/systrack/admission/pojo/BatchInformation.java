package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BatchInformation {
    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("SID")
    @Expose
    private Integer sID;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("BATCHID")
    @Expose
    private Integer bATCHID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("ACADEMICID")
    @Expose
    private Integer aCADEMICID;
    @SerializedName("COURSEID")
    @Expose
    private Integer cOURSEID;
    @SerializedName("BATCHNAME")
    @Expose
    private String bATCHNAME;
    @SerializedName("BATCHALIAS")
    @Expose
    private String bATCHALIAS;
    @SerializedName("STARTDATE")
    @Expose
    private String sTARTDATE;
    @SerializedName("ENDDATE")
    @Expose
    private String eNDDATE;
    @SerializedName("SECTIONNAME")
    @Expose
    private String sECTIONNAME;
    @SerializedName("INTAKE")
    @Expose
    private String iNTAKE;
    @SerializedName("CREATEDBY")
    @Expose
    private Integer cREATEDBY;
    @SerializedName("CREATEDAT")
    @Expose
    private String cREATEDAT;
    @SerializedName("MODIFIEDBY")
    @Expose
    private Object mODIFIEDBY;
    @SerializedName("MODIFIEDAT")
    @Expose
    private Object mODIFIEDAT;
    @SerializedName("BATCHSTATUS")
    @Expose
    private Boolean bATCHSTATUS;
    @SerializedName("ACADEMICNAME")
    @Expose
    private String aCADEMICNAME;
    @SerializedName("YEAR")
    @Expose
    private Integer yEAR;
    @SerializedName("BATCHSTARTDATE")
    @Expose
    private String bATCHSTARTDATE;
    @SerializedName("BATCHENDDATE")
    @Expose
    private String bATCHENDDATE;
    @SerializedName("COURSENAME")
    @Expose
    private String cOURSENAME;

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

    public Integer getBATCHID() {
        return bATCHID;
    }

    public void setBATCHID(Integer bATCHID) {
        this.bATCHID = bATCHID;
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

    public Integer getCOURSEID() {
        return cOURSEID;
    }

    public void setCOURSEID(Integer cOURSEID) {
        this.cOURSEID = cOURSEID;
    }

    public String getBATCHNAME() {
        return bATCHNAME;
    }

    public void setBATCHNAME(String bATCHNAME) {
        this.bATCHNAME = bATCHNAME;
    }

    public String getBATCHALIAS() {
        return bATCHALIAS;
    }

    public void setBATCHALIAS(String bATCHALIAS) {
        this.bATCHALIAS = bATCHALIAS;
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

    public String getSECTIONNAME() {
        return sECTIONNAME;
    }

    public void setSECTIONNAME(String sECTIONNAME) {
        this.sECTIONNAME = sECTIONNAME;
    }

    public String getINTAKE() {
        return iNTAKE;
    }

    public void setINTAKE(String iNTAKE) {
        this.iNTAKE = iNTAKE;
    }

    public Integer getCREATEDBY() {
        return cREATEDBY;
    }

    public void setCREATEDBY(Integer cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
    }

    public String getCREATEDAT() {
        return cREATEDAT;
    }

    public void setCREATEDAT(String cREATEDAT) {
        this.cREATEDAT = cREATEDAT;
    }

    public Object getMODIFIEDBY() {
        return mODIFIEDBY;
    }

    public void setMODIFIEDBY(Object mODIFIEDBY) {
        this.mODIFIEDBY = mODIFIEDBY;
    }

    public Object getMODIFIEDAT() {
        return mODIFIEDAT;
    }

    public void setMODIFIEDAT(Object mODIFIEDAT) {
        this.mODIFIEDAT = mODIFIEDAT;
    }

    public Boolean getBATCHSTATUS() {
        return bATCHSTATUS;
    }

    public void setBATCHSTATUS(Boolean bATCHSTATUS) {
        this.bATCHSTATUS = bATCHSTATUS;
    }

    public String getACADEMICNAME() {
        return aCADEMICNAME;
    }

    public void setACADEMICNAME(String aCADEMICNAME) {
        this.aCADEMICNAME = aCADEMICNAME;
    }

    public Integer getYEAR() {
        return yEAR;
    }

    public void setYEAR(Integer yEAR) {
        this.yEAR = yEAR;
    }

    public String getBATCHSTARTDATE() {
        return bATCHSTARTDATE;
    }

    public void setBATCHSTARTDATE(String bATCHSTARTDATE) {
        this.bATCHSTARTDATE = bATCHSTARTDATE;
    }

    public String getBATCHENDDATE() {
        return bATCHENDDATE;
    }

    public void setBATCHENDDATE(String bATCHENDDATE) {
        this.bATCHENDDATE = bATCHENDDATE;
    }

    public String getCOURSENAME() {
        return cOURSENAME;
    }

    public void setCOURSENAME(String cOURSENAME) {
        this.cOURSENAME = cOURSENAME;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
