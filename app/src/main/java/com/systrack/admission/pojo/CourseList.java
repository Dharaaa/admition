package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseList {
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("STUDENTCNT")
    @Expose
    private Integer sTUDENTCNT;
    @SerializedName("COURSENAME")
    @Expose
    private String cOURSENAME;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getSTUDENTCNT() {
        return sTUDENTCNT;
    }

    public void setSTUDENTCNT(Integer sTUDENTCNT) {
        this.sTUDENTCNT = sTUDENTCNT;
    }

    public String getCOURSENAME() {
        return cOURSENAME;
    }

    public void setCOURSENAME(String cOURSENAME) {
        this.cOURSENAME = cOURSENAME;
    }


}
