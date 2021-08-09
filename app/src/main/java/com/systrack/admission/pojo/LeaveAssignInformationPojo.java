package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeaveAssignInformationPojo {
    @SerializedName("LeaveAssignInformation")
    @Expose
    private List<LeaveAssignInformation> leaveAssignInformation = null;

    public List<LeaveAssignInformation> getLeaveAssignInformation() {
        return leaveAssignInformation;
    }

    public void setLeaveAssignInformation(List<LeaveAssignInformation> leaveAssignInformation) {
        this.leaveAssignInformation = leaveAssignInformation;
    }
}
