package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SectionInformationPojo {
    @SerializedName("SemesterInformation")
    @Expose
    private List<SectionInformation> semesterInformation = null;

    public List<SectionInformation> getSemesterInformation() {
        return semesterInformation;
    }

    public void setSemesterInformation(List<SectionInformation> semesterInformation) {
        this.semesterInformation = semesterInformation;
    }
}
