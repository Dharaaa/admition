package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClassTimingInformationPojo {
    @SerializedName("ClassTimingInformation")
    @Expose
    private List<ClassTimingInformation> classTimingInformation = null;

    public List<ClassTimingInformation> getClassTimingInformation() {
        return classTimingInformation;
    }

    public void setClassTimingInformation(List<ClassTimingInformation> classTimingInformation) {
        this.classTimingInformation = classTimingInformation;
    }



}
