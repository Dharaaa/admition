package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExamMasterInformationPojo {
    @SerializedName("ExamMasterInformation")
    @Expose
    private List<ExamMasterInformation> examMasterInformation = null;

    public List<ExamMasterInformation> getExamMasterInformation() {
        return examMasterInformation;
    }

    public void setExamMasterInformation(List<ExamMasterInformation> examMasterInformation) {
        this.examMasterInformation = examMasterInformation;
    }
}
