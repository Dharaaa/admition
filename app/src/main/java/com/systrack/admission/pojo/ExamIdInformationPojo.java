package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class ExamIdInformationPojo {
    @SerializedName("ExamIdInformation")
    @Expose
    private List<ExamIdInformation> examIdInformation = null;

    public List<ExamIdInformation> getExamIdInformation() {
        return examIdInformation;
    }

    public void setExamIdInformation(List<ExamIdInformation> examIdInformation) {
        this.examIdInformation = examIdInformation;
    }
}
