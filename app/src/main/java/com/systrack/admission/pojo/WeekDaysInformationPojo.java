package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeekDaysInformationPojo {
    @SerializedName("WeekDaysInformation")
    @Expose
    private List<WeekDaysInformation> weekDaysInformation = null;

    public List<WeekDaysInformation> getWeekDaysInformation() {
        return weekDaysInformation;
    }

    public void setWeekDaysInformation(List<WeekDaysInformation> weekDaysInformation) {
        this.weekDaysInformation = weekDaysInformation;
    }

}
