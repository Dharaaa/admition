package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClassDivisionInformationPojo {
    @SerializedName("ClassDivisionInformation")
    @Expose
    private List<ClassDivisionInformation> classDivisionInformation = null;

    public List<ClassDivisionInformation> getClassDivisionInformation() {
        return classDivisionInformation;
    }

    public void setClassDivisionInformation(List<ClassDivisionInformation> classDivisionInformation) {
        this.classDivisionInformation = classDivisionInformation;
    }
}
