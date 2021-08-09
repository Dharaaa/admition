package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainDashBoardInformationPojo {
    @SerializedName("DashboardInformation")
    @Expose
    private DashboardInformation dashBoardInformation;

    public DashboardInformation getDashBoardInformation() {
        return dashBoardInformation;
    }

    public void setDashBoardInformation(DashboardInformation dashBoardInformation) {
        this.dashBoardInformation = dashBoardInformation;
    }
}
