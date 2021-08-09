package com.systrack.admission.adapter.TimeTableAdapter;

/**
 * Created by Ulan on 07.09.2018.
 */
public class Week {

    private String subject, fragment, teacher, room, fromtime, totime, time,WEEKDAY,LABALIASNAME,LEAVEDATE,isDisplayPractical,MERGECLASSTIME,SECTIONID;
    private int id, color,CLASSTIMEID,BATCHID,DIVISIONID,ACADEMICID,LABID,ROOMID;

    public Week() {}

    public Week(String subject, String teacher, String room, String fromtime, String totime, int color,int labid,int roomid,String labname,String LEAVEDATE) {
        this.subject = subject;
        this.teacher = teacher;
        this.room = room;
        this.fromtime = fromtime;
        this.totime = totime;
        this.color = color;
        this.LABID = labid;
        this.ROOMID = roomid;
        this.LABALIASNAME = labname;
        this.LEAVEDATE = LEAVEDATE;
    }

    public String getMERGECLASSTIME() {
        return MERGECLASSTIME;
    }

    public void setMERGECLASSTIME(String MERGECLASSTIME) {
        this.MERGECLASSTIME = MERGECLASSTIME;
    }

    public String getIsDisplayPractical() {
        return isDisplayPractical;
    }

    public void setIsDisplayPractical(String isDisplayPractical) {
        this.isDisplayPractical = isDisplayPractical;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }

    public String getFromTime() {
        return fromtime;
    }

    public void setFromTime(String fromtime) {
        this.fromtime = fromtime;
    }

    public String getToTime() {
        return totime;
    }

    public void setToTime(String totime) {
        this.totime = totime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String toString() {
        return subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }


    public String getWEEKDAY() {
        return WEEKDAY;
    }

    public void setWEEKDAY(String WEEKDAY) {
        this.WEEKDAY = WEEKDAY;
    }

    public int getCLASSTIMEID() {
        return CLASSTIMEID;
    }

    public void setCLASSTIMEID(int CLASSTIMEID) {
        this.CLASSTIMEID = CLASSTIMEID;
    }

    public int getBATCHID() {
        return BATCHID;
    }

    public void setBATCHID(int BATCHID) {
        this.BATCHID = BATCHID;
    }

    public String getSECTIONID() {
        return SECTIONID;
    }

    public void setSECTIONID(String SECTIONID) {
        this.SECTIONID = SECTIONID;
    }

    public int getDIVISIONID() {
        return DIVISIONID;
    }

    public void setDIVISIONID(int DIVISIONID) {
        this.DIVISIONID = DIVISIONID;
    }

    public int getACADEMICID() {
        return ACADEMICID;
    }

    public void setACADEMICID(int ACADEMICID) {
        this.ACADEMICID = ACADEMICID;
    }

    public String getLABALIASNAME() {
        return LABALIASNAME;
    }

    public void setLABALIASNAME(String LABALIASNAME) {
        this.LABALIASNAME = LABALIASNAME;
    }

    public int getLABID() {
        return LABID;
    }

    public void setLABID(int LABID) {
        this.LABID = LABID;
    }

    public int getROOMID() {
        return ROOMID;
    }

    public void setROOMID(int ROOMID) {
        this.ROOMID = ROOMID;
    }

    public String getLEAVEDATE() {
        return LEAVEDATE;
    }

    public void setLEAVEDATE(String LEAVEDATE) {
        this.LEAVEDATE = LEAVEDATE;
    }


}
