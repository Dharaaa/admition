package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageInformation {


    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;

    @SerializedName("StatusCode")
        @Expose
        private String statusCode;
        @SerializedName("TotalCount")
        @Expose
        private Integer totalCount;
        @SerializedName("MESSAGEID")
        @Expose
        private Integer mESSAGEID;
        @SerializedName("DETAIL")
        @Expose
        private String dETAIL;
        @SerializedName("STATUS")
        @Expose
        private Boolean sTATUS;
        @SerializedName("CREATEDDATE")
        @Expose
        private String cREATEDDATE;
        @SerializedName("CREATEDBY")
        @Expose
        private Object cREATEDBY;
        @SerializedName("MODIFIEDBY")
        @Expose
        private Integer mODIFIEDBY;
        @SerializedName("MODIFIEDAT")
        @Expose
        private String mODIFIEDAT;
        @SerializedName("COLLEGEID")
        @Expose
        private Integer cOLLEGEID;
        @SerializedName("BRANCHID")
        @Expose
        private Integer bRANCHID;
        @SerializedName("USERTYPE")
        @Expose
        private String uSERTYPE;
        @SerializedName("MESSAGESTATUS")
        @Expose
        private String mESSAGESTATUS;
        @SerializedName("STATUSCLASS")
        @Expose
        private String sTATUSCLASS;

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

        public Integer getMESSAGEID() {
            return mESSAGEID;
        }

        public void setMESSAGEID(Integer mESSAGEID) {
            this.mESSAGEID = mESSAGEID;
        }

        public String getDETAIL() {
            return dETAIL;
        }

        public void setDETAIL(String dETAIL) {
            this.dETAIL = dETAIL;
        }

        public Boolean getSTATUS() {
            return sTATUS;
        }

        public void setSTATUS(Boolean sTATUS) {
            this.sTATUS = sTATUS;
        }

        public String getCREATEDDATE() {
            return cREATEDDATE;
        }

        public void setCREATEDDATE(String cREATEDDATE) {
            this.cREATEDDATE = cREATEDDATE;
        }

        public Object getCREATEDBY() {
            return cREATEDBY;
        }

        public void setCREATEDBY(Object cREATEDBY) {
            this.cREATEDBY = cREATEDBY;
        }

        public Integer getMODIFIEDBY() {
            return mODIFIEDBY;
        }

        public void setMODIFIEDBY(Integer mODIFIEDBY) {
            this.mODIFIEDBY = mODIFIEDBY;
        }

        public String getMODIFIEDAT() {
            return mODIFIEDAT;
        }

        public void setMODIFIEDAT(String mODIFIEDAT) {
            this.mODIFIEDAT = mODIFIEDAT;
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

        public String getUSERTYPE() {
            return uSERTYPE;
        }

        public void setUSERTYPE(String uSERTYPE) {
            this.uSERTYPE = uSERTYPE;
        }

        public String getMESSAGESTATUS() {
            return mESSAGESTATUS;
        }

        public void setMESSAGESTATUS(String mESSAGESTATUS) {
            this.mESSAGESTATUS = mESSAGESTATUS;
        }

        public String getSTATUSCLASS() {
            return sTATUSCLASS;
        }

        public void setSTATUSCLASS(String sTATUSCLASS) {
            this.sTATUSCLASS = sTATUSCLASS;
        }

    public String getDisplayMessage() {
        return DisplayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        DisplayMessage = displayMessage;
    }
}


