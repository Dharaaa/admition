package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentInformation {


    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;

    @SerializedName("StatusCode")
        @Expose
        private String statusCode;
        @SerializedName("TotalCount")
        @Expose
        private Integer totalCount;
        @SerializedName("ADMISSIONID")
        @Expose
        private Integer aDMISSIONID;
        @SerializedName("COLLEGEID")
        @Expose
        private Integer cOLLEGEID;
        @SerializedName("BRANCHID")
        @Expose
        private Integer bRANCHID;
        @SerializedName("STUDENTNO")
        @Expose
        private String sTUDENTNO;
        @SerializedName("STUDENTNAME")
        @Expose
        private String sTUDENTNAME;
        @SerializedName("STREAMID")
        @Expose
        private Integer sTREAMID;
        @SerializedName("SECTIONID")
        @Expose
        private String sECTIONID;
        @SerializedName("ACADEMICID")
        @Expose
        private Integer aCADEMICID;
        @SerializedName("EMAIL")
        @Expose
        private String eMAIL;
        @SerializedName("MOBILENO")
        @Expose
        private String mOBILENO;
        @SerializedName("DATEOFBIRTH")
        @Expose
        private String dATEOFBIRTH;
        @SerializedName("GENDER")
        @Expose
        private String gENDER;
        @SerializedName("USERNAME")
        @Expose
        private String uSERNAME;

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

        public Integer getADMISSIONID() {
            return aDMISSIONID;
        }

        public void setADMISSIONID(Integer aDMISSIONID) {
            this.aDMISSIONID = aDMISSIONID;
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

        public String getSTUDENTNO() {
            return sTUDENTNO;
        }

        public void setSTUDENTNO(String sTUDENTNO) {
            this.sTUDENTNO = sTUDENTNO;
        }

        public String getSTUDENTNAME() {
            return sTUDENTNAME;
        }

        public void setSTUDENTNAME(String sTUDENTNAME) {
            this.sTUDENTNAME = sTUDENTNAME;
        }

        public Integer getSTREAMID() {
            return sTREAMID;
        }

        public void setSTREAMID(Integer sTREAMID) {
            this.sTREAMID = sTREAMID;
        }

        public String getSECTIONID() {
            return sECTIONID;
        }

        public void setSECTIONID(String sECTIONID) {
            this.sECTIONID = sECTIONID;
        }

        public Integer getACADEMICID() {
            return aCADEMICID;
        }

        public void setACADEMICID(Integer aCADEMICID) {
            this.aCADEMICID = aCADEMICID;
        }

        public String getEMAIL() {
            return eMAIL;
        }

        public void setEMAIL(String eMAIL) {
            this.eMAIL = eMAIL;
        }

        public String getMOBILENO() {
            return mOBILENO;
        }

        public void setMOBILENO(String mOBILENO) {
            this.mOBILENO = mOBILENO;
        }

        public String getDATEOFBIRTH() {
            return dATEOFBIRTH;
        }

        public void setDATEOFBIRTH(String dATEOFBIRTH) {
            this.dATEOFBIRTH = dATEOFBIRTH;
        }

        public String getGENDER() {
            return gENDER;
        }

        public void setGENDER(String gENDER) {
            this.gENDER = gENDER;
        }

        public String getUSERNAME() {
            return uSERNAME;
        }

        public void setUSERNAME(String uSERNAME) {
            this.uSERNAME = uSERNAME;
        }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}


