package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TimeTableInformationPojo {
    @SerializedName("TimeTableInformation")
    @Expose
    private List<TimeTableInformation> timeTableInformation = null;

    public List<TimeTableInformation> getTimeTableInformation() {
        return timeTableInformation;
    }

    public void setTimeTableInformation(List<TimeTableInformation> timeTableInformation) {
        this.timeTableInformation = timeTableInformation;
    }
}
