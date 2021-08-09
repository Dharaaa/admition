package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeAttendanceInformationPojo {
    @SerializedName("EmployeeAttendanceInformation")
    @Expose
    private List<EmployeeAttendanceInformation> employeeAttendanceInformation = null;

    public List<EmployeeAttendanceInformation> getEmployeeAttendanceInformation() {
        return employeeAttendanceInformation;
    }

    public void setEmployeeAttendanceInformation(List<EmployeeAttendanceInformation> employeeAttendanceInformation) {
        this.employeeAttendanceInformation = employeeAttendanceInformation;
    }
}
