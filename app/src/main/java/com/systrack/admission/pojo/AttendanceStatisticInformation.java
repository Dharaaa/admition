package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttendanceStatisticInformation {

    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("STUDENTID")
    @Expose
    private Integer sTUDENTID;
    @SerializedName("IDNO")
    @Expose
    private Integer iDNO;
    @SerializedName("STUDENTNO")
    @Expose
    private String sTUDENTNO;
    @SerializedName("STUDENTNAME")
    @Expose
    private String sTUDENTNAME;
    @SerializedName("TotalLecture")
    @Expose
    private Integer totalLecture;
    @SerializedName("PresentLecture")
    @Expose
    private Integer presentLecture;
    @SerializedName("AbsentLecture")
    @Expose
    private Integer absentLecture;
    @SerializedName("Average")
    @Expose
    private Integer average;

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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getSTUDENTID() {
        return sTUDENTID;
    }

    public void setSTUDENTID(Integer sTUDENTID) {
        this.sTUDENTID = sTUDENTID;
    }

    public Integer getIDNO() {
        return iDNO;
    }

    public void setIDNO(Integer iDNO) {
        this.iDNO = iDNO;
    }

    public String getSTUDENTNO() {
        return sTUDENTNO;
    }

    public void setSTUDENTNO(String sTUDENTNO) {
        this.sTUDENTNO = sTUDENTNO;
    }

    public String getSTUDENTNAME() {
        return sTUDENTNAME;
    }

    public void setSTUDENTNAME(String sTUDENTNAME) {
        this.sTUDENTNAME = sTUDENTNAME;
    }

    public Integer getTotalLecture() {
        return totalLecture;
    }

    public void setTotalLecture(Integer totalLecture) {
        this.totalLecture = totalLecture;
    }

    public Integer getPresentLecture() {
        return presentLecture;
    }

    public void setPresentLecture(Integer presentLecture) {
        this.presentLecture = presentLecture;
    }

    public Integer getAbsentLecture() {
        return absentLecture;
    }

    public void setAbsentLecture(Integer absentLecture) {
        this.absentLecture = absentLecture;
    }

    public Integer getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

}

