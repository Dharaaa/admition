package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcademicyearInformationPojo {
    @SerializedName("AcademicyearInformation")
    @Expose
    private List<AcademicyearInformation> academicyearInformation = null;

    public List<AcademicyearInformation> getAcademicyearInformation() {
        return academicyearInformation;
    }

    public void setAcademicyearInformation(List<AcademicyearInformation> academicyearInformation) {
        this.academicyearInformation = academicyearInformation;
    }
}
