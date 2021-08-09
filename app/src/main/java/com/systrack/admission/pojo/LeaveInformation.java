package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeaveInformation {


        @SerializedName("DisplayMessage")
        @Expose
        private String DisplayMessage;
        @SerializedName("StatusCode")
        @Expose
        private String statusCode;
        @SerializedName("ROWNUM")
        @Expose
        private Integer rOWNUM;
        @SerializedName("TotalCount")
        @Expose
        private Integer totalCount;
        @SerializedName("LEAVEAPPID")
        @Expose
        private Integer lEAVEAPPID;
        @SerializedName("LEAVEDURATIONID")
        @Expose
        private Integer lEAVEDURATIONID;
        @SerializedName("LEAVETYPEID")
        @Expose
        private Integer lEAVETYPEID;
        @SerializedName("LEAVEAPPLYID")
        @Expose
        private Integer lEAVEAPPLYID;
        @SerializedName("LEAVEDATE")
        @Expose
        private String lEAVEDATE;
        @SerializedName("LEAVESTARTDATE")
        @Expose
        private String lEAVESTARTDATE;
        @SerializedName("LEAVEENDDATE")
        @Expose
        private String lEAVEENDDATE;
        @SerializedName("LEAVEDAYS")
        @Expose
        private Double lEAVEDAYS;
        @SerializedName("FIRSTHALFDAY")
        @Expose
        private Boolean fIRSTHALFDAY;
        @SerializedName("SECONDHALFDAY")
        @Expose
        private Boolean sECONDHALFDAY;
        @SerializedName("REASON")
        @Expose
        private String rEASON;
        @SerializedName("STATUS")
        @Expose
        private String sTATUS;
        @SerializedName("LEAVESTATUS")
        @Expose
        private String lEAVESTATUS;
        @SerializedName("ENTITYID")
        @Expose
        private Integer eNTITYID;
        @SerializedName("BRANCHID")
        @Expose
        private Integer bRANCHID;
        @SerializedName("PROCESSBY")
        @Expose
        private Integer pROCESSBY;
        @SerializedName("PROCESSDATE")
        @Expose
        private String pROCESSDATE;
        @SerializedName("REMARKS")
        @Expose
        private String rEMARKS;
        @SerializedName("PROCESSBY1")
        @Expose
        private Object pROCESSBY1;
        @SerializedName("PROCESSDATE1")
        @Expose
        private Object pROCESSDATE1;
        @SerializedName("REMARKS1")
        @Expose
        private Object rEMARKS1;
        @SerializedName("STATUS1")
        @Expose
        private Object sTATUS1;
        @SerializedName("FIRSTSESSION")
        @Expose
        private Boolean fIRSTSESSION;
        @SerializedName("SECONDSESSION")
        @Expose
        private Boolean sECONDSESSION;
        @SerializedName("PROCESSBYNAME")
        @Expose
        private String pROCESSBYNAME;
        @SerializedName("PROCESSBYNAME1")
        @Expose
        private Object pROCESSBYNAME1;
        @SerializedName("LEAVESTATUSCLASS1")
        @Expose
        private String lEAVESTATUSCLASS1;
        @SerializedName("LEAVESTATUSCLASS2")
        @Expose
        private String lEAVESTATUSCLASS2;
        @SerializedName("LEAVESTATUSCLASS")
        @Expose
        private String lEAVESTATUSCLASS;
        @SerializedName("EMPNAME")
        @Expose
        private String eMPNAME;
        @SerializedName("EMAIL")
        @Expose
        private String eMAIL;
        @SerializedName("CATEGORYID")
        @Expose
        private Integer cATEGORYID;
        @SerializedName("EMPLOYEEID")
        @Expose
        private Integer eMPLOYEEID;
        @SerializedName("COURSEID")
        @Expose
        private Integer cOURSEID;
        @SerializedName("DURATIONNAME")
        @Expose
        private String dURATIONNAME;
        @SerializedName("LEAVETYPENAME")
        @Expose
        private String lEAVETYPENAME;
        @SerializedName("PRINCIPALID")
        @Expose
        private Integer pRINCIPALID;
        @SerializedName("DSTARTDATE")
        @Expose
        private String dSTARTDATE;
        @SerializedName("DENDDATE")
        @Expose
        private String dENDDATE;
        @SerializedName("DLEAVETAKENDATE")
        @Expose
        private String dLEAVETAKENDATE;
        @SerializedName("STARTDATE")
        @Expose
        private String sTARTDATE;
        @SerializedName("ENDDATE")
        @Expose
        private String eNDDATE;
        @SerializedName("LEAVETAKENDATE")
        @Expose
        private String lEAVETAKENDATE;

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

        public Integer getLEAVEAPPID() {
            return lEAVEAPPID;
        }

        public void setLEAVEAPPID(Integer lEAVEAPPID) {
            this.lEAVEAPPID = lEAVEAPPID;
        }

        public Integer getLEAVEDURATIONID() {
            return lEAVEDURATIONID;
        }

        public void setLEAVEDURATIONID(Integer lEAVEDURATIONID) {
            this.lEAVEDURATIONID = lEAVEDURATIONID;
        }

        public Integer getLEAVETYPEID() {
            return lEAVETYPEID;
        }

        public void setLEAVETYPEID(Integer lEAVETYPEID) {
            this.lEAVETYPEID = lEAVETYPEID;
        }

        public Integer getLEAVEAPPLYID() {
            return lEAVEAPPLYID;
        }

        public void setLEAVEAPPLYID(Integer lEAVEAPPLYID) {
            this.lEAVEAPPLYID = lEAVEAPPLYID;
        }

        public String getLEAVEDATE() {
            return lEAVEDATE;
        }

        public void setLEAVEDATE(String lEAVEDATE) {
            this.lEAVEDATE = lEAVEDATE;
        }

        public String getLEAVESTARTDATE() {
            return lEAVESTARTDATE;
        }

        public void setLEAVESTARTDATE(String lEAVESTARTDATE) {
            this.lEAVESTARTDATE = lEAVESTARTDATE;
        }

        public String getLEAVEENDDATE() {
            return lEAVEENDDATE;
        }

        public void setLEAVEENDDATE(String lEAVEENDDATE) {
            this.lEAVEENDDATE = lEAVEENDDATE;
        }

        public Double getLEAVEDAYS() {
            return lEAVEDAYS;
        }

        public void setLEAVEDAYS(Double lEAVEDAYS) {
            this.lEAVEDAYS = lEAVEDAYS;
        }

        public Boolean getFIRSTHALFDAY() {
            return fIRSTHALFDAY;
        }

        public void setFIRSTHALFDAY(Boolean fIRSTHALFDAY) {
            this.fIRSTHALFDAY = fIRSTHALFDAY;
        }

        public Boolean getSECONDHALFDAY() {
            return sECONDHALFDAY;
        }

        public void setSECONDHALFDAY(Boolean sECONDHALFDAY) {
            this.sECONDHALFDAY = sECONDHALFDAY;
        }

        public String getREASON() {
            return rEASON;
        }

        public void setREASON(String rEASON) {
            this.rEASON = rEASON;
        }

        public String getSTATUS() {
            return sTATUS;
        }

        public void setSTATUS(String sTATUS) {
            this.sTATUS = sTATUS;
        }

        public String getLEAVESTATUS() {
            return lEAVESTATUS;
        }

        public void setLEAVESTATUS(String lEAVESTATUS) {
            this.lEAVESTATUS = lEAVESTATUS;
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

        public Integer getPROCESSBY() {
            return pROCESSBY;
        }

        public void setPROCESSBY(Integer pROCESSBY) {
            this.pROCESSBY = pROCESSBY;
        }

        public String getPROCESSDATE() {
            return pROCESSDATE;
        }

        public void setPROCESSDATE(String pROCESSDATE) {
            this.pROCESSDATE = pROCESSDATE;
        }

        public String getREMARKS() {
            return rEMARKS;
        }

        public void setREMARKS(String rEMARKS) {
            this.rEMARKS = rEMARKS;
        }

        public Object getPROCESSBY1() {
            return pROCESSBY1;
        }

        public void setPROCESSBY1(Object pROCESSBY1) {
            this.pROCESSBY1 = pROCESSBY1;
        }

        public Object getPROCESSDATE1() {
            return pROCESSDATE1;
        }

        public void setPROCESSDATE1(Object pROCESSDATE1) {
            this.pROCESSDATE1 = pROCESSDATE1;
        }

        public Object getREMARKS1() {
            return rEMARKS1;
        }

        public void setREMARKS1(Object rEMARKS1) {
            this.rEMARKS1 = rEMARKS1;
        }

        public Object getSTATUS1() {
            return sTATUS1;
        }

        public void setSTATUS1(Object sTATUS1) {
            this.sTATUS1 = sTATUS1;
        }

        public Boolean getFIRSTSESSION() {
            return fIRSTSESSION;
        }

        public void setFIRSTSESSION(Boolean fIRSTSESSION) {
            this.fIRSTSESSION = fIRSTSESSION;
        }

        public Boolean getSECONDSESSION() {
            return sECONDSESSION;
        }

        public void setSECONDSESSION(Boolean sECONDSESSION) {
            this.sECONDSESSION = sECONDSESSION;
        }

        public String getPROCESSBYNAME() {
            return pROCESSBYNAME;
        }

        public void setPROCESSBYNAME(String pROCESSBYNAME) {
            this.pROCESSBYNAME = pROCESSBYNAME;
        }

        public Object getPROCESSBYNAME1() {
            return pROCESSBYNAME1;
        }

        public void setPROCESSBYNAME1(Object pROCESSBYNAME1) {
            this.pROCESSBYNAME1 = pROCESSBYNAME1;
        }

        public String getLEAVESTATUSCLASS1() {
            return lEAVESTATUSCLASS1;
        }

        public void setLEAVESTATUSCLASS1(String lEAVESTATUSCLASS1) {
            this.lEAVESTATUSCLASS1 = lEAVESTATUSCLASS1;
        }

        public String getLEAVESTATUSCLASS2() {
            return lEAVESTATUSCLASS2;
        }

        public void setLEAVESTATUSCLASS2(String lEAVESTATUSCLASS2) {
            this.lEAVESTATUSCLASS2 = lEAVESTATUSCLASS2;
        }

        public String getLEAVESTATUSCLASS() {
            return lEAVESTATUSCLASS;
        }

        public void setLEAVESTATUSCLASS(String lEAVESTATUSCLASS) {
            this.lEAVESTATUSCLASS = lEAVESTATUSCLASS;
        }

        public String getEMPNAME() {
            return eMPNAME;
        }

        public void setEMPNAME(String eMPNAME) {
            this.eMPNAME = eMPNAME;
        }

        public String getEMAIL() {
            return eMAIL;
        }

        public void setEMAIL(String eMAIL) {
            this.eMAIL = eMAIL;
        }

        public Integer getCATEGORYID() {
            return cATEGORYID;
        }

        public void setCATEGORYID(Integer cATEGORYID) {
            this.cATEGORYID = cATEGORYID;
        }

        public Integer getEMPLOYEEID() {
            return eMPLOYEEID;
        }

        public void setEMPLOYEEID(Integer eMPLOYEEID) {
            this.eMPLOYEEID = eMPLOYEEID;
        }

        public Integer getCOURSEID() {
            return cOURSEID;
        }

        public void setCOURSEID(Integer cOURSEID) {
            this.cOURSEID = cOURSEID;
        }

        public String getDURATIONNAME() {
            return dURATIONNAME;
        }

        public void setDURATIONNAME(String dURATIONNAME) {
            this.dURATIONNAME = dURATIONNAME;
        }

        public String getLEAVETYPENAME() {
            return lEAVETYPENAME;
        }

        public void setLEAVETYPENAME(String lEAVETYPENAME) {
            this.lEAVETYPENAME = lEAVETYPENAME;
        }

        public Integer getPRINCIPALID() {
            return pRINCIPALID;
        }

        public void setPRINCIPALID(Integer pRINCIPALID) {
            this.pRINCIPALID = pRINCIPALID;
        }

        public String getDSTARTDATE() {
            return dSTARTDATE;
        }

        public void setDSTARTDATE(String dSTARTDATE) {
            this.dSTARTDATE = dSTARTDATE;
        }

        public String getDENDDATE() {
            return dENDDATE;
        }

        public void setDENDDATE(String dENDDATE) {
            this.dENDDATE = dENDDATE;
        }

        public String getDLEAVETAKENDATE() {
            return dLEAVETAKENDATE;
        }

        public void setDLEAVETAKENDATE(String dLEAVETAKENDATE) {
            this.dLEAVETAKENDATE = dLEAVETAKENDATE;
        }

        public String getSTARTDATE() {
            return sTARTDATE;
        }

        public void setSTARTDATE(String sTARTDATE) {
            this.sTARTDATE = sTARTDATE;
        }

        public String getENDDATE() {
            return eNDDATE;
        }

        public void setENDDATE(String eNDDATE) {
            this.eNDDATE = eNDDATE;
        }

        public String getLEAVETAKENDATE() {
            return lEAVETAKENDATE;
        }

        public void setLEAVETAKENDATE(String lEAVETAKENDATE) {
            this.lEAVETAKENDATE = lEAVETAKENDATE;
        }


    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }
}


