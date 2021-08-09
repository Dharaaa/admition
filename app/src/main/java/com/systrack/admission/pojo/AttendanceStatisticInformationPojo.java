package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AttendanceStatisticInformationPojo {
    @SerializedName("StudentAttendanceInformation")
    @Expose
    private List<AttendanceStatisticInformation> studentAttendanceInformation = null;

    public List<AttendanceStatisticInformation> getStudentAttendanceInformation() {
        return studentAttendanceInformation;
    }

    public void setStudentAttendanceInformation(List<AttendanceStatisticInformation> studentAttendanceInformation) {
        this.studentAttendanceInformation = studentAttendanceInformation;
    }
}
