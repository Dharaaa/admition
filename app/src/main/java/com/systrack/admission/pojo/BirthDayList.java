package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BirthDayList {

    @SerializedName("FULLNAME")
    @Expose
    private String FULLNAME;
    @SerializedName("DESIGNATIONNAME")
    @Expose
    private String DESIGNATIONNAME;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("Message")
    @Expose
    private String message;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFULLNAME() {
        return FULLNAME;
    }

    public void setFULLNAME(String FULLNAME) {
        this.FULLNAME = FULLNAME;
    }

    public String getDESIGNATIONNAME() {
        return DESIGNATIONNAME;
    }

    public void setDESIGNATIONNAME(String DESIGNATIONNAME) {
        this.DESIGNATIONNAME = DESIGNATIONNAME;
    }
}
