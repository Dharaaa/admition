package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeacherAllocationInformationPojo {
    @SerializedName("TeacherAllocationInformation")
    @Expose
    private List<TeacherAllocationInformation> teacherAllocationInformation = null;

    public List<TeacherAllocationInformation> getTeacherAllocationInformation() {
        return teacherAllocationInformation;
    }

    public void setTeacherAllocationInformation(List<TeacherAllocationInformation> teacherAllocationInformation) {
        this.teacherAllocationInformation = teacherAllocationInformation;
    }
}
