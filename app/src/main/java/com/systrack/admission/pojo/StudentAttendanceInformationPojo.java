package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentAttendanceInformationPojo {
    @SerializedName("StudentAttendanceInformation")
    @Expose
    private List<StudentAttendanceInformation> studentAttendanceInformation = null;

    public List<StudentAttendanceInformation> getStudentAttendanceInformation() {
        return studentAttendanceInformation;
    }

    public void setStudentAttendanceInformation(List<StudentAttendanceInformation> studentAttendanceInformation) {
        this.studentAttendanceInformation = studentAttendanceInformation;
    }
}
