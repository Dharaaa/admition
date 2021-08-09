package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentInformationPojo {
    @SerializedName("StudentInformation")
    @Expose
    private List<StudentInformation> studentInformation = null;

    public List<StudentInformation> getStudentInformation() {
        return studentInformation;
    }

    public void setStudentInformation(List<StudentInformation> studentInformation) {
        this.studentInformation = studentInformation;
    }
}
