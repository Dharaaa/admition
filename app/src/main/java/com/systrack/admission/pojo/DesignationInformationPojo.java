package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DesignationInformationPojo {
    @SerializedName("DesignationInformation")
    @Expose
    private List<DesignationInformation> designationInformation = null;

    public List<DesignationInformation> getDesignationInformation() {
        return designationInformation;
    }

    public void setDesignationInformation(List<DesignationInformation> designationInformation) {
        this.designationInformation = designationInformation;
    }
}
