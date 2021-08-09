package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HallArrangementStudentInformation {


    @SerializedName("STUDENTNAME")
    @Expose
    private String STUDENTNAME;
    @SerializedName("STUDENTNO")
    @Expose
    private String STUDENTNO;
    @SerializedName("SECTIONNAME")
    @Expose
    private String SECTIONNAME;
    @SerializedName("BATCHNAME")
    @Expose
    private String BATCHNAME;



    @SerializedName("TotalCount")
    @Expose
    private Integer TotalCount;
    @SerializedName("DisplayMessage")
    @Expose
    private String DisplayMessage;
    @SerializedName("ROOMMASTERNAME")
    @Expose
    private String rOOMMASTERNAME;
    @SerializedName("ROOMMASTERID")
    @Expose
    private Integer ROOMMASTERID;
    @SerializedName("DISPLAYEXAMTIME")
    @Expose
    private String dISPLAYEXAMTIME;
    @SerializedName("HALLNO")
    @Expose
    private String hALLNO;
    @SerializedName("SUPERVISORNAME")
    @Expose
    private String sUPERVISORNAME;
    @SerializedName("ALLOCATEDSEAT")
    @Expose
    private Integer aLLOCATEDSEAT;
    @SerializedName("SEATCAPACITY")
    @Expose
    private Integer sEATCAPACITY;

    public String getdISPLAYEXAMTIME() {
        return dISPLAYEXAMTIME;
    }

    public void setdISPLAYEXAMTIME(String dISPLAYEXAMTIME) {
        this.dISPLAYEXAMTIME = dISPLAYEXAMTIME;
    }

    public String gethALLNO() {
        return hALLNO;
    }

    public void sethALLNO(String hALLNO) {
        this.hALLNO = hALLNO;
    }

    public String getsUPERVISORNAME() {
        return sUPERVISORNAME;
    }

    public void setsUPERVISORNAME(String sUPERVISORNAME) {
        this.sUPERVISORNAME = sUPERVISORNAME;
    }

    public Integer getaLLOCATEDSEAT() {
        return aLLOCATEDSEAT;
    }

    public void setaLLOCATEDSEAT(Integer aLLOCATEDSEAT) {
        this.aLLOCATEDSEAT = aLLOCATEDSEAT;
    }

    public Integer getsEATCAPACITY() {
        return sEATCAPACITY;
    }

    public void setsEATCAPACITY(Integer sEATCAPACITY) {
        this.sEATCAPACITY = sEATCAPACITY;
    }

    public Integer getROOMMASTERID() {
        return ROOMMASTERID;
    }

    public void setROOMMASTERID(Integer ROOMMASTERID) {
        this.ROOMMASTERID = ROOMMASTERID;
    }

    @SerializedName("StatusCode")
        @Expose
        private String statusCode;
        @SerializedName("INTERNALEXAMID")
        @Expose
        private Integer iNTERNALEXAMID;
        @SerializedName("ENTITYID")
        @Expose
        private Integer eNTITYID;
        @SerializedName("BRANCHID")
        @Expose
        private Integer bRANCHID;
        @SerializedName("EXAMNAME")
        @Expose
        private String eXAMNAME;
        @SerializedName("DESCRIPTION")
        @Expose
        private String dESCRIPTION;
        @SerializedName("EXAMSTATUS")
        @Expose
        private Boolean eXAMSTATUS;
        @SerializedName("STATUS")
        @Expose
        private String sTATUS;
        @SerializedName("STATUSCLASS")
        @Expose
        private String sTATUSCLASS;

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public Integer getINTERNALEXAMID() {
            return iNTERNALEXAMID;
        }

        public void setINTERNALEXAMID(Integer iNTERNALEXAMID) {
            this.iNTERNALEXAMID = iNTERNALEXAMID;
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

        public String getEXAMNAME() {
            return eXAMNAME;
        }

        public void setEXAMNAME(String eXAMNAME) {
            this.eXAMNAME = eXAMNAME;
        }

        public String getDESCRIPTION() {
            return dESCRIPTION;
        }

        public void setDESCRIPTION(String dESCRIPTION) {
            this.dESCRIPTION = dESCRIPTION;
        }

        public Boolean getEXAMSTATUS() {
            return eXAMSTATUS;
        }

        public void setEXAMSTATUS(Boolean eXAMSTATUS) {
            this.eXAMSTATUS = eXAMSTATUS;
        }

        public String getSTATUS() {
            return sTATUS;
        }

        public void setSTATUS(String sTATUS) {
            this.sTATUS = sTATUS;
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

    public String getrOOMMASTERNAME() {
        return rOOMMASTERNAME;
    }

    public void setrOOMMASTERNAME(String rOOMMASTERNAME) {
        this.rOOMMASTERNAME = rOOMMASTERNAME;
    }

    public Integer getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(Integer totalCount) {
        TotalCount = totalCount;
    }

    public String getSTUDENTNAME() {
        return STUDENTNAME;
    }

    public void setSTUDENTNAME(String STUDENTNAME) {
        this.STUDENTNAME = STUDENTNAME;
    }

    public String getSTUDENTNO() {
        return STUDENTNO;
    }

    public void setSTUDENTNO(String STUDENTNO) {
        this.STUDENTNO = STUDENTNO;
    }

    public String getSECTIONNAME() {
        return SECTIONNAME;
    }

    public void setSECTIONNAME(String SECTIONNAME) {
        this.SECTIONNAME = SECTIONNAME;
    }

    public String getBATCHNAME() {
        return BATCHNAME;
    }

    public void setBATCHNAME(String BATCHNAME) {
        this.BATCHNAME = BATCHNAME;
    }
//    public Integer getDISPLAYEXAMTIME() {
//        return DISPLAYEXAMTIME;
//    }
//
//    public void setDISPLAYEXAMTIME(Integer DISPLAYEXAMTIME) {
//        this.DISPLAYEXAMTIME = DISPLAYEXAMTIME;
//    }
}
