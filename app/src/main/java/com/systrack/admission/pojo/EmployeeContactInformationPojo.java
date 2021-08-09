package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeContactInformationPojo {
    @SerializedName("EmployeeContactInformation")
    @Expose
    private List<EmployeeContactInformation> employeeContactInformation = null;

    public List<EmployeeContactInformation> getEmployeeContactInformation() {
        return employeeContactInformation;
    }

    public void setEmployeeContactInformation(List<EmployeeContactInformation> employeeContactInformation) {
        this.employeeContactInformation = employeeContactInformation;
    }
}
