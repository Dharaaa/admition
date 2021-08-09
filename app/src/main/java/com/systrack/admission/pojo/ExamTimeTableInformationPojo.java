package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExamTimeTableInformationPojo {
    @SerializedName("ExamTimeTableInformation")
    @Expose
    private List<ExamTimeTableInformation> examTimeTableInformation = null;

    public List<ExamTimeTableInformation> getExamTimeTableInformation() {
        return examTimeTableInformation;
    }

    public void setExamTimeTableInformation(List<ExamTimeTableInformation> examTimeTableInformation) {
        this.examTimeTableInformation = examTimeTableInformation;
    }
}
