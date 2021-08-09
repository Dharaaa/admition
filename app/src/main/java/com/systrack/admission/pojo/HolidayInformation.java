package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HolidayInformation {

    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;

    @SerializedName("StatusCode")
        @Expose
        private String statusCode;
        @SerializedName("ROWNUM")
        @Expose
        private Integer rOWNUM;
        @SerializedName("TotalCount")
        @Expose
        private Integer totalCount;
        @SerializedName("HOLIDAYID")
        @Expose
        private Integer hOLIDAYID;
        @SerializedName("HOLIDAYNAME")
        @Expose
        private String hOLIDAYNAME;
        @SerializedName("HOLIDAYDATE")
        @Expose
        private String hOLIDAYDATE;
        @SerializedName("REMARKS")
        @Expose
        private String rEMARKS;
        @SerializedName("STATUS")
        @Expose
        private Boolean sTATUS;
        @SerializedName("ENTITYID")
        @Expose
        private Integer eNTITYID;
        @SerializedName("BRANCHID")
        @Expose
        private Integer bRANCHID;
        @SerializedName("CREATEDBY")
        @Expose
        private Integer cREATEDBY;
        @SerializedName("CREATEDDATETIME")
        @Expose
        private String cREATEDDATETIME;
        @SerializedName("MODIFIEDBY")
        @Expose
        private Integer mODIFIEDBY;
        @SerializedName("MODIFIEDDATETIME")
        @Expose
        private String mODIFIEDDATETIME;
        @SerializedName("DISPLAYHOLIDAYDATEMMDDYYYY")
        @Expose
        private String dISPLAYHOLIDAYDATEMMDDYYYY;
        @SerializedName("DISPLAYHOLIDAYDATEDDMMMYYYY")
        @Expose
        private String dISPLAYHOLIDAYDATEDDMMMYYYY;
        @SerializedName("DISPLAYSTATUS")
        @Expose
        private String dISPLAYSTATUS;
        @SerializedName("STATUSCLASS")
        @Expose
        private String sTATUSCLASS;

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public Integer getROWNUM() {
            return rOWNUM;
        }

        public void setROWNUM(Integer rOWNUM) {
            this.rOWNUM = rOWNUM;
        }

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

        public Integer getHOLIDAYID() {
            return hOLIDAYID;
        }

        public void setHOLIDAYID(Integer hOLIDAYID) {
            this.hOLIDAYID = hOLIDAYID;
        }

        public String getHOLIDAYNAME() {
            return hOLIDAYNAME;
        }

        public void setHOLIDAYNAME(String hOLIDAYNAME) {
            this.hOLIDAYNAME = hOLIDAYNAME;
        }

        public String getHOLIDAYDATE() {
            return hOLIDAYDATE;
        }

        public void setHOLIDAYDATE(String hOLIDAYDATE) {
            this.hOLIDAYDATE = hOLIDAYDATE;
        }

        public String getREMARKS() {
            return rEMARKS;
        }

        public void setREMARKS(String rEMARKS) {
            this.rEMARKS = rEMARKS;
        }

        public Boolean getSTATUS() {
            return sTATUS;
        }

        public void setSTATUS(Boolean sTATUS) {
            this.sTATUS = sTATUS;
        }

        public Integer getENTITYID() {
            return eNTITYID;
        }

        public void setENTITYID(Integer eNTITYID) {
            this.eNTITYID = eNTITYID;
        }

        public Integer getBRANCHID() {
            return bRANCHID;
        }

        public void setBRANCHID(Integer bRANCHID) {
            this.bRANCHID = bRANCHID;
        }

        public Integer getCREATEDBY() {
            return cREATEDBY;
        }

        public void setCREATEDBY(Integer cREATEDBY) {
            this.cREATEDBY = cREATEDBY;
        }

        public String getCREATEDDATETIME() {
            return cREATEDDATETIME;
        }

        public void setCREATEDDATETIME(String cREATEDDATETIME) {
            this.cREATEDDATETIME = cREATEDDATETIME;
        }

        public Integer getMODIFIEDBY() {
            return mODIFIEDBY;
        }

        public void setMODIFIEDBY(Integer mODIFIEDBY) {
            this.mODIFIEDBY = mODIFIEDBY;
        }

        public String getMODIFIEDDATETIME() {
            return mODIFIEDDATETIME;
        }

        public void setMODIFIEDDATETIME(String mODIFIEDDATETIME) {
            this.mODIFIEDDATETIME = mODIFIEDDATETIME;
        }

        public String getDISPLAYHOLIDAYDATEMMDDYYYY() {
            return dISPLAYHOLIDAYDATEMMDDYYYY;
        }

        public void setDISPLAYHOLIDAYDATEMMDDYYYY(String dISPLAYHOLIDAYDATEMMDDYYYY) {
            this.dISPLAYHOLIDAYDATEMMDDYYYY = dISPLAYHOLIDAYDATEMMDDYYYY;
        }

        public String getDISPLAYHOLIDAYDATEDDMMMYYYY() {
            return dISPLAYHOLIDAYDATEDDMMMYYYY;
        }

        public void setDISPLAYHOLIDAYDATEDDMMMYYYY(String dISPLAYHOLIDAYDATEDDMMMYYYY) {
            this.dISPLAYHOLIDAYDATEDDMMMYYYY = dISPLAYHOLIDAYDATEDDMMMYYYY;
        }

        public String getDISPLAYSTATUS() {
            return dISPLAYSTATUS;
        }

        public void setDISPLAYSTATUS(String dISPLAYSTATUS) {
            this.dISPLAYSTATUS = dISPLAYSTATUS;
        }

        public String getSTATUSCLASS() {
            return sTATUSCLASS;
        }

        public void setSTATUSCLASS(String sTATUSCLASS) {
            this.sTATUSCLASS = sTATUSCLASS;
        }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}


