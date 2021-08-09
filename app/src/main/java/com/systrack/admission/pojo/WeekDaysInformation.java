package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeekDaysInformation {
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("WEEKDAYSID")
    @Expose
    private Integer wEEKDAYSID;
    @SerializedName("BATCHID")
    @Expose
    private Integer bATCHID;
    @SerializedName("SECTIONID")
    @Expose
    private Integer sECTIONID;
    @SerializedName("MONDAY")
    @Expose
    private Boolean mONDAY;
    @SerializedName("TUESDAY")
    @Expose
    private Boolean tUESDAY;
    @SerializedName("WEDNESDAY")
    @Expose
    private Boolean wEDNESDAY;
    @SerializedName("THURSEDAY")
    @Expose
    private Boolean tHURSEDAY;
    @SerializedName("FRIDAY")
    @Expose
    private Boolean fRIDAY;
    @SerializedName("SATURDAY")
    @Expose
    private Boolean sATURDAY;
    @SerializedName("SUNDAY")
    @Expose
    private Boolean sUNDAY;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("CREATEDBY")
    @Expose
    private Integer cREATEDBY;
    @SerializedName("CREATEDATETIME")
    @Expose
    private String cREATEDATETIME;
    @SerializedName("FHSTARTTIME")
    @Expose
    private String fHSTARTTIME;
    @SerializedName("FHENDTIME")
    @Expose
    private String fHENDTIME;
    @SerializedName("SHSTARTTIME")
    @Expose
    private String sHSTARTTIME;
    @SerializedName("SHENDTIME")
    @Expose
    private String sHENDTIME;
    @SerializedName("WEEKOFFTYPE_SUN")
    @Expose
    private String wEEKOFFTYPESUN;
    @SerializedName("WEEKOFFTYPE_MON")
    @Expose
    private String wEEKOFFTYPEMON;
    @SerializedName("WEEKOFFTYPE_TUE")
    @Expose
    private String wEEKOFFTYPETUE;
    @SerializedName("WEEKOFFTYPE_WED")
    @Expose
    private String wEEKOFFTYPEWED;
    @SerializedName("WEEKOFFTYPE_THU")
    @Expose
    private String wEEKOFFTYPETHU;
    @SerializedName("WEEKOFFTYPE_FRI")
    @Expose
    private String wEEKOFFTYPEFRI;
    @SerializedName("WEEKOFFTYPE_SAT")
    @Expose
    private String wEEKOFFTYPESAT;
    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;


    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getWEEKDAYSID() {
        return wEEKDAYSID;
    }

    public void setWEEKDAYSID(Integer wEEKDAYSID) {
        this.wEEKDAYSID = wEEKDAYSID;
    }

    public Integer getBATCHID() {
        return bATCHID;
    }

    public void setBATCHID(Integer bATCHID) {
        this.bATCHID = bATCHID;
    }

    public Integer getSECTIONID() {
        return sECTIONID;
    }

    public void setSECTIONID(Integer sECTIONID) {
        this.sECTIONID = sECTIONID;
    }

    public Boolean getMONDAY() {
        return mONDAY;
    }

    public void setMONDAY(Boolean mONDAY) {
        this.mONDAY = mONDAY;
    }

    public Boolean getTUESDAY() {
        return tUESDAY;
    }

    public void setTUESDAY(Boolean tUESDAY) {
        this.tUESDAY = tUESDAY;
    }

    public Boolean getWEDNESDAY() {
        return wEDNESDAY;
    }

    public void setWEDNESDAY(Boolean wEDNESDAY) {
        this.wEDNESDAY = wEDNESDAY;
    }

    public Boolean getTHURSEDAY() {
        return tHURSEDAY;
    }

    public void setTHURSEDAY(Boolean tHURSEDAY) {
        this.tHURSEDAY = tHURSEDAY;
    }

    public Boolean getFRIDAY() {
        return fRIDAY;
    }

    public void setFRIDAY(Boolean fRIDAY) {
        this.fRIDAY = fRIDAY;
    }

    public Boolean getSATURDAY() {
        return sATURDAY;
    }

    public void setSATURDAY(Boolean sATURDAY) {
        this.sATURDAY = sATURDAY;
    }

    public Boolean getSUNDAY() {
        return sUNDAY;
    }

    public void setSUNDAY(Boolean sUNDAY) {
        this.sUNDAY = sUNDAY;
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

    public Integer getCREATEDBY() {
        return cREATEDBY;
    }

    public void setCREATEDBY(Integer cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
    }

    public String getCREATEDATETIME() {
        return cREATEDATETIME;
    }

    public void setCREATEDATETIME(String cREATEDATETIME) {
        this.cREATEDATETIME = cREATEDATETIME;
    }

    public String getFHSTARTTIME() {
        return fHSTARTTIME;
    }

    public void setFHSTARTTIME(String fHSTARTTIME) {
        this.fHSTARTTIME = fHSTARTTIME;
    }

    public String getFHENDTIME() {
        return fHENDTIME;
    }

    public void setFHENDTIME(String fHENDTIME) {
        this.fHENDTIME = fHENDTIME;
    }

    public String getSHSTARTTIME() {
        return sHSTARTTIME;
    }

    public void setSHSTARTTIME(String sHSTARTTIME) {
        this.sHSTARTTIME = sHSTARTTIME;
    }

    public String getSHENDTIME() {
        return sHENDTIME;
    }

    public void setSHENDTIME(String sHENDTIME) {
        this.sHENDTIME = sHENDTIME;
    }

    public String getWEEKOFFTYPESUN() {
        return wEEKOFFTYPESUN;
    }

    public void setWEEKOFFTYPESUN(String wEEKOFFTYPESUN) {
        this.wEEKOFFTYPESUN = wEEKOFFTYPESUN;
    }

    public String getWEEKOFFTYPEMON() {
        return wEEKOFFTYPEMON;
    }

    public void setWEEKOFFTYPEMON(String wEEKOFFTYPEMON) {
        this.wEEKOFFTYPEMON = wEEKOFFTYPEMON;
    }

    public String getWEEKOFFTYPETUE() {
        return wEEKOFFTYPETUE;
    }

    public void setWEEKOFFTYPETUE(String wEEKOFFTYPETUE) {
        this.wEEKOFFTYPETUE = wEEKOFFTYPETUE;
    }

    public String getWEEKOFFTYPEWED() {
        return wEEKOFFTYPEWED;
    }

    public void setWEEKOFFTYPEWED(String wEEKOFFTYPEWED) {
        this.wEEKOFFTYPEWED = wEEKOFFTYPEWED;
    }

    public String getWEEKOFFTYPETHU() {
        return wEEKOFFTYPETHU;
    }

    public void setWEEKOFFTYPETHU(String wEEKOFFTYPETHU) {
        this.wEEKOFFTYPETHU = wEEKOFFTYPETHU;
    }

    public String getWEEKOFFTYPEFRI() {
        return wEEKOFFTYPEFRI;
    }

    public void setWEEKOFFTYPEFRI(String wEEKOFFTYPEFRI) {
        this.wEEKOFFTYPEFRI = wEEKOFFTYPEFRI;
    }

    public String getWEEKOFFTYPESAT() {
        return wEEKOFFTYPESAT;
    }

    public void setWEEKOFFTYPESAT(String wEEKOFFTYPESAT) {
        this.wEEKOFFTYPESAT = wEEKOFFTYPESAT;
    }


}
