package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ManageEmployeeInformationPojo {
    @SerializedName("EmployeeInformation")
    @Expose
    private List<ManageEmployeeInformation> employeeInformation = null;

    public List<ManageEmployeeInformation> getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(List<ManageEmployeeInformation> employeeInformation) {
        this.employeeInformation = employeeInformation;
    }
}
