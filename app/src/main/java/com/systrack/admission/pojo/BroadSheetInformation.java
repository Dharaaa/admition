package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BroadSheetInformation {

    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("StudentNo")
    @Expose
    private String studentNo;
    @SerializedName("StudentName")
    @Expose
    private String studentName;
    @SerializedName("English")
    @Expose
    private String english;
    @SerializedName("Disaster Management")
    @Expose
    private String disasterManagement;
    @SerializedName("Economic")
    @Expose
    private String economic;
    @SerializedName("Gujarati")
    @Expose
    private String gujarati;
    @SerializedName("Hindi")
    @Expose
    private String hindi;
    @SerializedName("Human Rights")
    @Expose
    private String humanRights;
    @SerializedName("Sanskrit")
    @Expose
    private String sanskrit;
    @SerializedName("Sociology")
    @Expose
    private String sociology;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getDisasterManagement() {
        return disasterManagement;
    }

    public void setDisasterManagement(String disasterManagement) {
        this.disasterManagement = disasterManagement;
    }

    public String getEconomic() {
        return economic;
    }

    public void setEconomic(String economic) {
        this.economic = economic;
    }

    public String getGujarati() {
        return gujarati;
    }

    public void setGujarati(String gujarati) {
        this.gujarati = gujarati;
    }

    public String getHindi() {
        return hindi;
    }

    public void setHindi(String hindi) {
        this.hindi = hindi;
    }

    public String getHumanRights() {
        return humanRights;
    }

    public void setHumanRights(String humanRights) {
        this.humanRights = humanRights;
    }

    public String getSanskrit() {
        return sanskrit;
    }

    public void setSanskrit(String sanskrit) {
        this.sanskrit = sanskrit;
    }

    public String getSociology() {
        return sociology;
    }

    public void setSociology(String sociology) {
        this.sociology = sociology;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    @Override
    public String toString() {
        return "studentNo='" + studentNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", english='" + english + '\'' +
                ", disasterManagement='" + disasterManagement + '\'' +
                ", economic='" + economic + '\'' +
                ", gujarati='" + gujarati + '\'' +
                ", hindi='" + hindi + '\'' +
                ", humanRights='" + humanRights + '\'' +
                ", sanskrit='" + sanskrit + '\'' +
                ", sociology='" + sociology ;
    }
}
