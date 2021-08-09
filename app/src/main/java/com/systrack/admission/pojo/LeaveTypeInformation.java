package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaveTypeInformation {

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
    @SerializedName("LEAVETYPEID")
    @Expose
    private Integer lEAVETYPEID;
    @SerializedName("ENTITYID")
    @Expose
    private Integer eNTITYID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("GENDER")
    @Expose
    private String gENDER;
    @SerializedName("LEAVETYPENAME")
    @Expose
    private String lEAVETYPENAME;
    @SerializedName("LEAVETYPEDETAIL")
    @Expose
    private String lEAVETYPEDETAIL;

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

    public Integer getLEAVETYPEID() {
        return lEAVETYPEID;
    }

    public void setLEAVETYPEID(Integer lEAVETYPEID) {
        this.lEAVETYPEID = lEAVETYPEID;
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

    public String getGENDER() {
        return gENDER;
    }

    public void setGENDER(String gENDER) {
        this.gENDER = gENDER;
    }

    public String getLEAVETYPENAME() {
        return lEAVETYPENAME;
    }

    public void setLEAVETYPENAME(String lEAVETYPENAME) {
        this.lEAVETYPENAME = lEAVETYPENAME;
    }

    public String getLEAVETYPEDETAIL() {
        return lEAVETYPEDETAIL;
    }

    public void setLEAVETYPEDETAIL(String lEAVETYPEDETAIL) {
        this.lEAVETYPEDETAIL = lEAVETYPEDETAIL;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }
}
