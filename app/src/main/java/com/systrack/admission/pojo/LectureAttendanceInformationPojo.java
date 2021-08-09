package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LectureAttendanceInformationPojo {
    @SerializedName("LectureAttendanceInformation")
    @Expose
    private List<LectureAttendanceInformation> lectureAttendanceInformation = null;

    public List<LectureAttendanceInformation> getLectureAttendanceInformation() {
        return lectureAttendanceInformation;
    }

    public void setLectureAttendanceInformation(List<LectureAttendanceInformation> lectureAttendanceInformation) {
        this.lectureAttendanceInformation = lectureAttendanceInformation;
    }
}
