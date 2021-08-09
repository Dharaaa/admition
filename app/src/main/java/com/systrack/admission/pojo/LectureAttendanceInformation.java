package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LectureAttendanceInformation {

    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;

    @SerializedName("StatusCode")
        @Expose
        private String statusCode;
        @SerializedName("TotalCount")
        @Expose
        private Integer totalCount;
        @SerializedName("STUDENTID")
        @Expose
        private Integer sTUDENTID;
        @SerializedName("STUDENTNO")
        @Expose
        private String sTUDENTNO;
        @SerializedName("FULLNAME")
        @Expose
        private String fULLNAME;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("PA")
        @Expose
        private String pA;
        @SerializedName("ABSENTREMARK")
        @Expose
        private Object aBSENTREMARK;
        @SerializedName("attendancedate")
        @Expose
        private String attendancedate;
        @SerializedName("STU_ATTE_MASTERID")
        @Expose
        private Integer sTUATTEMASTERID;
        @SerializedName("CREATEDBY")
        @Expose
        private Integer cREATEDBY;
        @SerializedName("PACLASS")
        @Expose
        private String pACLASS;
        @SerializedName("CREATEDDATE")
        @Expose
        private String cREATEDDATE;
        @SerializedName("LECTURERNAME")
        @Expose
        private String lECTURERNAME;

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

        public Integer getSTUDENTID() {
            return sTUDENTID;
        }

        public void setSTUDENTID(Integer sTUDENTID) {
            this.sTUDENTID = sTUDENTID;
        }

        public String getSTUDENTNO() {
            return sTUDENTNO;
        }

        public void setSTUDENTNO(String sTUDENTNO) {
            this.sTUDENTNO = sTUDENTNO;
        }

        public String getFULLNAME() {
            return fULLNAME;
        }

        public void setFULLNAME(String fULLNAME) {
            this.fULLNAME = fULLNAME;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getPA() {
            return pA;
        }

        public void setPA(String pA) {
            this.pA = pA;
        }

        public Object getABSENTREMARK() {
            return aBSENTREMARK;
        }

        public void setABSENTREMARK(Object aBSENTREMARK) {
            this.aBSENTREMARK = aBSENTREMARK;
        }

        public String getAttendancedate() {
            return attendancedate;
        }

        public void setAttendancedate(String attendancedate) {
            this.attendancedate = attendancedate;
        }

        public Integer getSTUATTEMASTERID() {
            return sTUATTEMASTERID;
        }

        public void setSTUATTEMASTERID(Integer sTUATTEMASTERID) {
            this.sTUATTEMASTERID = sTUATTEMASTERID;
        }

        public Integer getCREATEDBY() {
            return cREATEDBY;
        }

        public void setCREATEDBY(Integer cREATEDBY) {
            this.cREATEDBY = cREATEDBY;
        }

        public String getPACLASS() {
            return pACLASS;
        }

        public void setPACLASS(String pACLASS) {
            this.pACLASS = pACLASS;
        }

        public String getCREATEDDATE() {
            return cREATEDDATE;
        }

        public void setCREATEDDATE(String cREATEDDATE) {
            this.cREATEDDATE = cREATEDDATE;
        }

        public String getLECTURERNAME() {
            return lECTURERNAME;
        }

        public void setLECTURERNAME(String lECTURERNAME) {
            this.lECTURERNAME = lECTURERNAME;
        }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }
}

