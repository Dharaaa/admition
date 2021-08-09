package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HolidayInformationPojo {
    @SerializedName("HolidayInformation")
    @Expose
    private List<HolidayInformation> holidayInformation = null;

    public List<HolidayInformation> getHolidayInformation() {
        return holidayInformation;
    }

    public void setHolidayInformation(List<HolidayInformation> holidayInformation) {
        this.holidayInformation = holidayInformation;
    }
}
