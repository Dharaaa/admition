package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AcademicyearInformation {

    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("YEARID")
    @Expose
    private Integer yEARID;
    @SerializedName("COLLEGEID")
    @Expose
    private Integer cOLLEGEID;
    @SerializedName("YEAR")
    @Expose
    private Integer yEAR;
    @SerializedName("ISCURRENTYEAR")
    @Expose
    private Boolean iSCURRENTYEAR;
    @SerializedName("ISACTIVE")
    @Expose
    private Integer iSACTIVE;
    @SerializedName("STATUS")
    @Expose
    private String sTATUS;
    @SerializedName("CLASS")
    @Expose
    private String cLASS;
    @SerializedName("COMBINEYEAR")
    @Expose
    private String cOMBINEYEAR;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getYEARID() {
        return yEARID;
    }

    public void setYEARID(Integer yEARID) {
        this.yEARID = yEARID;
    }

    public Integer getCOLLEGEID() {
        return cOLLEGEID;
    }

    public void setCOLLEGEID(Integer cOLLEGEID) {
        this.cOLLEGEID = cOLLEGEID;
    }

    public Integer getYEAR() {
        return yEAR;
    }

    public void setYEAR(Integer yEAR) {
        this.yEAR = yEAR;
    }

    public Boolean getISCURRENTYEAR() {
        return iSCURRENTYEAR;
    }

    public void setISCURRENTYEAR(Boolean iSCURRENTYEAR) {
        this.iSCURRENTYEAR = iSCURRENTYEAR;
    }

    public Integer getISACTIVE() {
        return iSACTIVE;
    }

    public void setISACTIVE(Integer iSACTIVE) {
        this.iSACTIVE = iSACTIVE;
    }

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String getCLASS() {
        return cLASS;
    }

    public void setCLASS(String cLASS) {
        this.cLASS = cLASS;
    }

    public String getCOMBINEYEAR() {
        return cOMBINEYEAR;
    }

    public void setCOMBINEYEAR(String cOMBINEYEAR) {
        this.cOMBINEYEAR = cOMBINEYEAR;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }
}
