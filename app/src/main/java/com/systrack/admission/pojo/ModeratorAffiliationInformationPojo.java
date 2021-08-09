package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModeratorAffiliationInformationPojo {
    @SerializedName("ModeratorAffiliationInformation")
    @Expose
    private List<ModeratorAffiliationInformation> moderatorAffiliationInformation = null;

    public List<ModeratorAffiliationInformation> getModeratorAffiliationInformation() {
        return moderatorAffiliationInformation;
    }

    public void setModeratorAffiliationInformation(List<ModeratorAffiliationInformation> moderatorAffiliationInformation) {
        this.moderatorAffiliationInformation = moderatorAffiliationInformation;
    }
}
