package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ManageEmployeeCoursePojo {
    @SerializedName("EmployeeInformation")
    @Expose
    private List<ManageEmployeeCourseInformation> employeeInformation = null;

    public List<ManageEmployeeCourseInformation> getEmployeeInformation() {
        return employeeInformation;
    }

    public void setEmployeeInformation(List<ManageEmployeeCourseInformation> employeeInformation) {
        this.employeeInformation = employeeInformation;
    }
}
