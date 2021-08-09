package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DashboardInformation {

    @SerializedName("NOTICEDISPLAYDATE")
    @Expose
    private String NOTICEDISPLAYDATE;
    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("TOTALCOUNT")
    @Expose
    private Integer tOTALCOUNT;
    @SerializedName("NOTICEID")
    @Expose
    private Integer nOTICEID;
    @SerializedName("COLLEGEID")
    @Expose
    private Integer cOLLEGEID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("TITLE")
    @Expose
    private String tITLE;
    @SerializedName("NOTICEDATE")
    @Expose
    private String nOTICEDATE;
    @SerializedName("DISPLAYNOTICEDATE")
    @Expose
    private String dISPLAYNOTICEDATE;
    @SerializedName("DESCRIPTION")
    @Expose
    private String dESCRIPTION;
    @SerializedName("USERTYPE")
    @Expose
    private Integer uSERTYPE;
    @SerializedName("STATUS")
    @Expose
    private Boolean sTATUS;
    @SerializedName("FILEPATH")
    @Expose
    private String fILEPATH;
    @SerializedName("CREATEDDATE")
    @Expose
    private String cREATEDDATE;
    @SerializedName("CREATEDBY")
    @Expose
    private Integer cREATEDBY;
    @SerializedName("MODIFIEDAT")
    @Expose
    private Object mODIFIEDAT;
    @SerializedName("MODIFIEDBY")
    @Expose
    private Object mODIFIEDBY;
    @SerializedName("NOTICESTATUS")
    @Expose
    private String nOTICESTATUS;
    @SerializedName("STATUSCLASS")
    @Expose
    private String sTATUSCLASS;
    @SerializedName("COURSEID")
    @Expose
    private String cOURSEID;
    @SerializedName("COURSENAME")
    @Expose
    private String cOURSENAME;
    @SerializedName("MesageOfDay")
    @Expose
    private List<MesageOfDay> mesageOfDay = null;
    @SerializedName("BirthDayList")
    @Expose
    private List<BirthDayList> birthDayList = null;
    @SerializedName("EmployeeStudentCount")
    @Expose
    private List<EmployeeStudentCount> employeeStudentCount = null;
    @SerializedName("CourseList")
    @Expose
    private List<CourseList> courseList = null;


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getTOTALCOUNT() {
        return tOTALCOUNT;
    }

    public void setTOTALCOUNT(Integer tOTALCOUNT) {
        this.tOTALCOUNT = tOTALCOUNT;
    }

    public Integer getNOTICEID() {
        return nOTICEID;
    }

    public void setNOTICEID(Integer nOTICEID) {
        this.nOTICEID = nOTICEID;
    }

    public Integer getCOLLEGEID() {
        return cOLLEGEID;
    }

    public void setCOLLEGEID(Integer cOLLEGEID) {
        this.cOLLEGEID = cOLLEGEID;
    }

    public Integer getBRANCHID() {
        return bRANCHID;
    }

    public void setBRANCHID(Integer bRANCHID) {
        this.bRANCHID = bRANCHID;
    }

    public String getTITLE() {
        return tITLE;
    }

    public void setTITLE(String tITLE) {
        this.tITLE = tITLE;
    }

    public String getNOTICEDATE() {
        return nOTICEDATE;
    }

    public void setNOTICEDATE(String nOTICEDATE) {
        this.nOTICEDATE = nOTICEDATE;
    }

    public String getDISPLAYNOTICEDATE() {
        return dISPLAYNOTICEDATE;
    }

    public void setDISPLAYNOTICEDATE(String dISPLAYNOTICEDATE) {
        this.dISPLAYNOTICEDATE = dISPLAYNOTICEDATE;
    }

    public String getDESCRIPTION() {
        return dESCRIPTION;
    }

    public void setDESCRIPTION(String dESCRIPTION) {
        this.dESCRIPTION = dESCRIPTION;
    }

    public Integer getUSERTYPE() {
        return uSERTYPE;
    }

    public void setUSERTYPE(Integer uSERTYPE) {
        this.uSERTYPE = uSERTYPE;
    }

    public Boolean getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(Boolean sTATUS) {
        this.sTATUS = sTATUS;
    }

    public String getFILEPATH() {
        return fILEPATH;
    }

    public void setFILEPATH(String fILEPATH) {
        this.fILEPATH = fILEPATH;
    }

    public String getCREATEDDATE() {
        return cREATEDDATE;
    }

    public void setCREATEDDATE(String cREATEDDATE) {
        this.cREATEDDATE = cREATEDDATE;
    }

    public Integer getCREATEDBY() {
        return cREATEDBY;
    }

    public void setCREATEDBY(Integer cREATEDBY) {
        this.cREATEDBY = cREATEDBY;
    }

    public Object getMODIFIEDAT() {
        return mODIFIEDAT;
    }

    public void setMODIFIEDAT(Object mODIFIEDAT) {
        this.mODIFIEDAT = mODIFIEDAT;
    }

    public Object getMODIFIEDBY() {
        return mODIFIEDBY;
    }

    public void setMODIFIEDBY(Object mODIFIEDBY) {
        this.mODIFIEDBY = mODIFIEDBY;
    }

    public String getNOTICESTATUS() {
        return nOTICESTATUS;
    }

    public void setNOTICESTATUS(String nOTICESTATUS) {
        this.nOTICESTATUS = nOTICESTATUS;
    }

    public String getSTATUSCLASS() {
        return sTATUSCLASS;
    }

    public void setSTATUSCLASS(String sTATUSCLASS) {
        this.sTATUSCLASS = sTATUSCLASS;
    }

    public String getCOURSEID() {
        return cOURSEID;
    }

    public void setCOURSEID(String cOURSEID) {
        this.cOURSEID = cOURSEID;
    }

    public String getCOURSENAME() {
        return cOURSENAME;
    }

    public void setCOURSENAME(String cOURSENAME) {
        this.cOURSENAME = cOURSENAME;
    }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }

    public List<MesageOfDay> getMesageOfDay() {
        return mesageOfDay;
    }

    public void setMesageOfDay(List<MesageOfDay> mesageOfDay) {
        this.mesageOfDay = mesageOfDay;
    }

    public List<BirthDayList> getBirthDayList() {
        return birthDayList;
    }

    public void setBirthDayList(List<BirthDayList> birthDayList) {
        this.birthDayList = birthDayList;
    }

    public List<EmployeeStudentCount> getEmployeeStudentCount() {
        return employeeStudentCount;
    }

    public void setEmployeeStudentCount(List<EmployeeStudentCount> employeeStudentCount) {
        this.employeeStudentCount = employeeStudentCount;
    }

    public List<CourseList> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseList> courseList) {
        this.courseList = courseList;
    }

    public String getNOTICEDISPLAYDATE() {
        return NOTICEDISPLAYDATE;
    }

    public void setNOTICEDISPLAYDATE(String NOTICEDISPLAYDATE) {
        this.NOTICEDISPLAYDATE = NOTICEDISPLAYDATE;
    }
}
