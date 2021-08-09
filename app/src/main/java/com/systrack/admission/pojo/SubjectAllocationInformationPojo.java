package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubjectAllocationInformationPojo {
    @SerializedName("SubjectAllocationInformation")
    @Expose
    private List<SubjectAllocationInformation> subjectAllocationInformation = null;

    public List<SubjectAllocationInformation> getSubjectAllocationInformation() {
        return subjectAllocationInformation;
    }

    public void setSubjectAllocationInformation(List<SubjectAllocationInformation> subjectAllocationInformation) {
        this.subjectAllocationInformation = subjectAllocationInformation;
    }
}
