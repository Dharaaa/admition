package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HallArrangementStudentInformationPojo {
    @SerializedName("HallArrangementStudentInformation")
    @Expose
    private List<HallArrangementStudentInformation> hallArrangementStudentInformation = null;

    public List<HallArrangementStudentInformation> getHallArrangementStudentInformation() {
        return hallArrangementStudentInformation;
    }

    public void setHallArrangementStudentInformation(List<HallArrangementStudentInformation> hallArrangementStudentInformation) {
        this.hallArrangementStudentInformation = hallArrangementStudentInformation;
    }
}
