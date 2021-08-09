package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExamMasterInformation {

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("ROWNUM")
    @Expose
    private Integer rOWNUM;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("INTERNALEXAMID")
    @Expose
    private Integer iNTERNALEXAMID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("EXAMNAME")
    @Expose
    private String eXAMNAME;
    @SerializedName("DESCRIPTION")
    @Expose
    private String dESCRIPTION;
    @SerializedName("EXAMSTATUS")
    @Expose
    private Boolean eXAMSTATUS;
    @SerializedName("STATUS")
    @Expose
    private String sTATUS;
    @SerializedName("STATUSCLASS")
    @Expose
    private String sTATUSCLASS;
    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
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

    public Integer getINTERNALEXAMID() {
        return iNTERNALEXAMID;
    }

    public void setINTERNALEXAMID(Integer iNTERNALEXAMID) {
        this.iNTERNALEXAMID = iNTERNALEXAMID;
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

    public String getEXAMNAME() {
        return eXAMNAME;
    }

    public void setEXAMNAME(String eXAMNAME) {
        this.eXAMNAME = eXAMNAME;
    }

    public String getDESCRIPTION() {
        return dESCRIPTION;
    }

    public void setDESCRIPTION(String dESCRIPTION) {
        this.dESCRIPTION = dESCRIPTION;
    }

    public Boolean getEXAMSTATUS() {
        return eXAMSTATUS;
    }

    public void setEXAMSTATUS(Boolean eXAMSTATUS) {
        this.eXAMSTATUS = eXAMSTATUS;
    }

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String getSTATUSCLASS() {
        return sTATUSCLASS;
    }

    public void setSTATUSCLASS(String sTATUSCLASS) {
        this.sTATUSCLASS = sTATUSCLASS;
    }


}
