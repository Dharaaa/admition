package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ManageEmployeeCourseInformation {

    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;

    @SerializedName("CATEGORYID")
    @Expose
    private int cATEGORYID;
    @SerializedName("CATEGORYNAME")
    @Expose
    private String cATEGORYNAME;
    @SerializedName("DESIGNATIONID")
    @Expose
    private int dESIGNATIONID;
    @SerializedName("DESIGNATIONNAME")
    @Expose
    private String dESIGNATIONNAME;
    @SerializedName("DEPARTMENTID")
    @Expose
    private int dEPARTMENTID;
    @SerializedName("DEPARTMENTNAME")
    @Expose
    private String dEPARTMENTNAME;
    @SerializedName("DEPARTMENTALIAS")
    @Expose
    private String dEPARTMENTALIAS;
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("STREAMID")
    @Expose
    private Integer sTREAMID;
    @SerializedName("COLLEGEID")
    @Expose
    private Integer cOLLEGEID;
    @SerializedName("STREAMNAME")
    @Expose
    private String sTREAMNAME;
    @SerializedName("DESCRIPTION")
    @Expose
    private String dESCRIPTION;
    @SerializedName("STREAMTYPE")
    @Expose
    private Integer sTREAMTYPE;
    @SerializedName("YEALY")
    @Expose
    private String yEALY;
    @SerializedName("SEMESTER")
    @Expose
    private String sEMESTER;
    @SerializedName("STATUS")
    @Expose
    private Boolean sTATUS;
    @SerializedName("ALTSTATUS")
    @Expose
    private String aLTSTATUS;
    @SerializedName("MEDIUM")
    @Expose
    private String mEDIUM;
    @SerializedName("DEGREETYPE")
    @Expose
    private String dEGREETYPE;
    @SerializedName("SHORTCODE")
    @Expose
    private String sHORTCODE;
    @SerializedName("ISSELFFINANCE")
    @Expose
    private Boolean iSSELFFINANCE;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getSTREAMID() {
        return sTREAMID;
    }

    public void setSTREAMID(Integer sTREAMID) {
        this.sTREAMID = sTREAMID;
    }

    public Integer getCOLLEGEID() {
        return cOLLEGEID;
    }

    public void setCOLLEGEID(Integer cOLLEGEID) {
        this.cOLLEGEID = cOLLEGEID;
    }

    public String getSTREAMNAME() {
        return sTREAMNAME;
    }

    public void setSTREAMNAME(String sTREAMNAME) {
        this.sTREAMNAME = sTREAMNAME;
    }

    public String getDESCRIPTION() {
        return dESCRIPTION;
    }

    public void setDESCRIPTION(String dESCRIPTION) {
        this.dESCRIPTION = dESCRIPTION;
    }

    public Integer getSTREAMTYPE() {
        return sTREAMTYPE;
    }

    public void setSTREAMTYPE(Integer sTREAMTYPE) {
        this.sTREAMTYPE = sTREAMTYPE;
    }

    public String getYEALY() {
        return yEALY;
    }

    public void setYEALY(String yEALY) {
        this.yEALY = yEALY;
    }

    public String getSEMESTER() {
        return sEMESTER;
    }

    public void setSEMESTER(String sEMESTER) {
        this.sEMESTER = sEMESTER;
    }

    public Boolean getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(Boolean sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String getALTSTATUS() {
        return aLTSTATUS;
    }

    public void setALTSTATUS(String aLTSTATUS) {
        this.aLTSTATUS = aLTSTATUS;
    }

    public String getMEDIUM() {
        return mEDIUM;
    }

    public void setMEDIUM(String mEDIUM) {
        this.mEDIUM = mEDIUM;
    }

    public String getDEGREETYPE() {
        return dEGREETYPE;
    }

    public void setDEGREETYPE(String dEGREETYPE) {
        this.dEGREETYPE = dEGREETYPE;
    }

    public String getSHORTCODE() {
        return sHORTCODE;
    }

    public void setSHORTCODE(String sHORTCODE) {
        this.sHORTCODE = sHORTCODE;
    }

    public Boolean getISSELFFINANCE() {
        return iSSELFFINANCE;
    }

    public void setISSELFFINANCE(Boolean iSSELFFINANCE) {
        this.iSSELFFINANCE = iSSELFFINANCE;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }

    public int getdEPARTMENTID() {
        return dEPARTMENTID;
    }

    public void setdEPARTMENTID(int dEPARTMENTID) {
        this.dEPARTMENTID = dEPARTMENTID;
    }

    public String getdEPARTMENTNAME() {
        return dEPARTMENTNAME;
    }

    public void setdEPARTMENTNAME(String dEPARTMENTNAME) {
        this.dEPARTMENTNAME = dEPARTMENTNAME;
    }

    public String getdEPARTMENTALIAS() {
        return dEPARTMENTALIAS;
    }

    public void setdEPARTMENTALIAS(String dEPARTMENTALIAS) {
        this.dEPARTMENTALIAS = dEPARTMENTALIAS;
    }

    public int getdESIGNATIONID() {
        return dESIGNATIONID;
    }

    public void setdESIGNATIONID(int dESIGNATIONID) {
        this.dESIGNATIONID = dESIGNATIONID;
    }

    public String getdESIGNATIONNAME() {
        return dESIGNATIONNAME;
    }

    public void setdESIGNATIONNAME(String dESIGNATIONNAME) {
        this.dESIGNATIONNAME = dESIGNATIONNAME;
    }

    public int getcATEGORYID() {
        return cATEGORYID;
    }

    public void setcATEGORYID(int cATEGORYID) {
        this.cATEGORYID = cATEGORYID;
    }

    public String getcATEGORYNAME() {
        return cATEGORYNAME;
    }

    public void setcATEGORYNAME(String cATEGORYNAME) {
        this.cATEGORYNAME = cATEGORYNAME;
    }
}
