package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeInformationPojo {
    @SerializedName("EmployeeInformation")
    @Expose
    private List<EmployeeInformation> employeeInformation = null;

    public List<EmployeeInformation> getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(List<EmployeeInformation> employeeInformation) {
        this.employeeInformation = employeeInformation;
    }

}

