package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeStudentCount {
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("EmployeeData")
    @Expose
    private Integer employeeData;
    @SerializedName("StudentData")
    @Expose
    private Integer studentData;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getEmployeeData() {
        return employeeData;
    }

    public void setEmployeeData(Integer employeeData) {
        this.employeeData = employeeData;
    }

    public Integer getStudentData() {
        return studentData;
    }

    public void setStudentData(Integer studentData) {
        this.studentData = studentData;
    }

}
