package com.systrack.admission.pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class RoomCategoryInformation {


    @SerializedName("BATCHNAME")
    @Expose
    private String bATCHNAME;
    @SerializedName("BATCHID")
    @Expose
    private Integer bATCHID;

    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;
        @SerializedName("StatusCode")
        @Expose
        private String statusCode;
        @SerializedName("ROOMMASTERID")
        @Expose
        private Integer rOOMMASTERID;
        @SerializedName("ROOMMASTERNAME")
        @Expose
        private String rOOMMASTERNAME;
        @SerializedName("ROOMCATEGORYID")
        @Expose
        private Integer rOOMCATEGORYID;
        @SerializedName("SEATCAPACITY")
        @Expose
        private Integer sEATCAPACITY;
        @SerializedName("LOCATION")
        @Expose
        private String lOCATION;
        @SerializedName("ENTITYID")
        @Expose
        private Integer eNTITYID;
        @SerializedName("BRANCHID")
        @Expose
        private Integer bRANCHID;
        @SerializedName("CREATEDBY")
        @Expose
        private Integer cREATEDBY;
        @SerializedName("CREATEDDATE")
        @Expose
        private String cREATEDDATE;
        @SerializedName("MODIFYBY")
        @Expose
        private Object mODIFYBY;
        @SerializedName("MODIFIEDDATE")
        @Expose
        private Object mODIFIEDDATE;
        @SerializedName("ROOMCATEGORYNAME")
        @Expose
        private String rOOMCATEGORYNAME;
        @SerializedName("ROOMALIASNAME")
        @Expose
        private String rOOMALIASNAME;
        @SerializedName("CATEGORYTYPE")
        @Expose
        private Integer cATEGORYTYPE;

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public Integer getROOMMASTERID() {
            return rOOMMASTERID;
        }

        public void setROOMMASTERID(Integer rOOMMASTERID) {
            this.rOOMMASTERID = rOOMMASTERID;
        }

        public String getROOMMASTERNAME() {
            return rOOMMASTERNAME;
        }

        public void setROOMMASTERNAME(String rOOMMASTERNAME) {
            this.rOOMMASTERNAME = rOOMMASTERNAME;
        }

        public Integer getROOMCATEGORYID() {
            return rOOMCATEGORYID;
        }

        public void setROOMCATEGORYID(Integer rOOMCATEGORYID) {
            this.rOOMCATEGORYID = rOOMCATEGORYID;
        }

        public Integer getSEATCAPACITY() {
            return sEATCAPACITY;
        }

        public void setSEATCAPACITY(Integer sEATCAPACITY) {
            this.sEATCAPACITY = sEATCAPACITY;
        }

        public String getLOCATION() {
            return lOCATION;
        }

        public void setLOCATION(String lOCATION) {
            this.lOCATION = lOCATION;
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

        public String getCREATEDDATE() {
            return cREATEDDATE;
        }

        public void setCREATEDDATE(String cREATEDDATE) {
            this.cREATEDDATE = cREATEDDATE;
        }

        public Object getMODIFYBY() {
            return mODIFYBY;
        }

        public void setMODIFYBY(Object mODIFYBY) {
            this.mODIFYBY = mODIFYBY;
        }

        public Object getMODIFIEDDATE() {
            return mODIFIEDDATE;
        }

        public void setMODIFIEDDATE(Object mODIFIEDDATE) {
            this.mODIFIEDDATE = mODIFIEDDATE;
        }

        public String getROOMCATEGORYNAME() {
            return rOOMCATEGORYNAME;
        }

        public void setROOMCATEGORYNAME(String rOOMCATEGORYNAME) {
            this.rOOMCATEGORYNAME = rOOMCATEGORYNAME;
        }

        public String getROOMALIASNAME() {
            return rOOMALIASNAME;
        }

        public void setROOMALIASNAME(String rOOMALIASNAME) {
            this.rOOMALIASNAME = rOOMALIASNAME;
        }

        public Integer getCATEGORYTYPE() {
            return cATEGORYTYPE;
        }

        public void setCATEGORYTYPE(Integer cATEGORYTYPE) {
            this.cATEGORYTYPE = cATEGORYTYPE;
        }

    public String getDisplayMessage() {
        return displayMessage;
    }

        public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getbATCHNAME() {
        return bATCHNAME;
    }

    public void setbATCHNAME(String bATCHNAME) {
        this.bATCHNAME = bATCHNAME;
    }

    public Integer getbATCHID() {
        return bATCHID;
    }

    public void setbATCHID(Integer bATCHID) {
        this.bATCHID = bATCHID;
    }
}
