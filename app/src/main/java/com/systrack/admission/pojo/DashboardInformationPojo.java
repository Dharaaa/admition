package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DashboardInformationPojo {
    @SerializedName("DashboardInformation")
    @Expose
    private List<DashboardInformation> dashboardInformation = null;

//    @SerializedName("DashBoardInformation")
//    @Expose
//    private List<DashboardInformation> dashboardInformationMain = null;


    public List<DashboardInformation> getDashboardInformation() {
        return dashboardInformation;
    }

    public void setDashboardInformation(List<DashboardInformation> dashboardInformation) {
        this.dashboardInformation = dashboardInformation;
    }



}
