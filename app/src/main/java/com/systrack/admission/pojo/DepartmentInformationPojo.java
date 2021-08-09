package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DepartmentInformationPojo {
    @SerializedName("DepartmentInformation")
    @Expose
    private List<DepartmentInformation> departmentInformation = null;

    public List<DepartmentInformation> getDepartmentInformation() {
        return departmentInformation;
    }

    public void setDepartmentInformation(List<DepartmentInformation> departmentInformation) {
        this.departmentInformation = departmentInformation;
    }
}
