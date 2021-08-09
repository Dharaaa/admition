package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AdmissionYearInformationPojo {
    @SerializedName("AdmissionYearInformation")
    @Expose
    private List<AdmissionYearInformation> admissionYearInformation = null;

    public List<AdmissionYearInformation> getAdmissionYearInformation() {
        return admissionYearInformation;
    }

    public void setAdmissionYearInformation(List<AdmissionYearInformation> admissionYearInformation) {
        this.admissionYearInformation = admissionYearInformation;
    }
}
