package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenerateMarksheetInformationPojo {
    @SerializedName("GenerateMarksheetInformation")
    @Expose
    private List<GenerateMarksheetInformation> generateMarksheetInformation = null;

    public List<GenerateMarksheetInformation> getGenerateMarksheetInformation() {
        return generateMarksheetInformation;
    }

    public void setGenerateMarksheetInformation(List<GenerateMarksheetInformation> generateMarksheetInformation) {
        this.generateMarksheetInformation = generateMarksheetInformation;
    }
}
