package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeTableInformation {

    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;
    @SerializedName("DAYNAME")
    @Expose
    private String DAYNAME;
    @SerializedName("DAYID")
    @Expose
    private String DAYID;
    @SerializedName("DISPLAYSTARTTIME")
    @Expose
    private String DISPLAYSTARTTIME;
    @SerializedName("EMPROOMLABTYPE")
    @Expose
    private String EMPROOMLABTYPE;


    @SerializedName("StatusCode")
        @Expose
        private String statusCode;
        @SerializedName("LECTUREID")
        @Expose
        private Integer lECTUREID;
        @SerializedName("ENTITYID")
        @Expose
        private Integer eNTITYID;
        @SerializedName("BRANCHID")
        @Expose
        private Integer bRANCHID;
        @SerializedName("BATCHID")
        @Expose
        private Integer bATCHID;
        @SerializedName("SECTIONID")
        @Expose
        private String sECTIONID;
        @SerializedName("SUBID")
        @Expose
        private Integer sUBID;
        @SerializedName("EMPID")
        @Expose
        private Integer eMPID;
        @SerializedName("ROOMID")
        @Expose
        private Integer rOOMID;
        @SerializedName("LABID")
        @Expose
        private Integer lABID;
        @SerializedName("DIVISIONID")
        @Expose
        private Integer dIVISIONID;
        @SerializedName("LOCATIONID")
        @Expose
        private Integer lOCATIONID;
        @SerializedName("LABNAME")
        @Expose
        private String lABNAME;
        @SerializedName("LABFULLNAME")
        @Expose
        private String lABFULLNAME;
        @SerializedName("DIVISIONNAME")
        @Expose
        private String dIVISIONNAME;
        @SerializedName("DIVISIONFULLNAME")
        @Expose
        private String dIVISIONFULLNAME;
        @SerializedName("LOCNAME")
        @Expose
        private String lOCNAME;
        @SerializedName("LOCATION")
        @Expose
        private String lOCATION;
        @SerializedName("LABALIASNAME")
        @Expose
        private String lABALIASNAME;
        @SerializedName("USERID")
        @Expose
        private Integer uSERID;
        @SerializedName("CLASSTIME")
        @Expose
        private String cLASSTIME;
        @SerializedName("WEEKDAY")
        @Expose
        private String wEEKDAY;
        @SerializedName("REMARKS")
        @Expose
        private String rEMARKS;
        @SerializedName("CLASSTIMEID")
        @Expose
        private Integer cLASSTIMEID;
        @SerializedName("COURSEID")
        @Expose
        private Integer cOURSEID;
        @SerializedName("ACADEMICID")
        @Expose
        private Integer aCADEMICID;
        @SerializedName("STARTTIME")
        @Expose
        private String sTARTTIME;
        @SerializedName("ENDTIME")
        @Expose
        private String eNDTIME;
        @SerializedName("CLASSTIMING")
        @Expose
        private String cLASSTIMING;
        @SerializedName("MONDAY")
        @Expose
        private Boolean mONDAY;
        @SerializedName("TUESDAY")
        @Expose
        private Boolean tUESDAY;
        @SerializedName("WEDNESDAY")
        @Expose
        private Boolean wEDNESDAY;
        @SerializedName("THURSEDAY")
        @Expose
        private Boolean tHURSEDAY;
        @SerializedName("FRIDAY")
        @Expose
        private Boolean fRIDAY;
        @SerializedName("SATURDAY")
        @Expose
        private Boolean sATURDAY;
        @SerializedName("SUNDAY")
        @Expose
        private Boolean sUNDAY;
        @SerializedName("EMPFULLNAME")
        @Expose
        private String eMPFULLNAME;
        @SerializedName("NAMEALIAS")
        @Expose
        private String nAMEALIAS;
        @SerializedName("EMPTIMETABLETYPE")
        @Expose
        private String eMPTIMETABLETYPE;
        @SerializedName("EMPSTATUS")
        @Expose
        private String eMPSTATUS;
        @SerializedName("ROMMNAME")
        @Expose
        private String rOMMNAME;
        @SerializedName("ROOMALIAS")
        @Expose
        private String rOOMALIAS;
        @SerializedName("SUBNAME")
        @Expose
        private String sUBNAME;
        @SerializedName("SUBJECTALIAS")
        @Expose
        private String sUBJECTALIAS;
        @SerializedName("ISBREAK")
        @Expose
        private Boolean iSBREAK;
        @SerializedName("BATCHNAME")
        @Expose
        private String bATCHNAME;
        @SerializedName("COURSENAME")
        @Expose
        private String cOURSENAME;
        @SerializedName("LEAVEDATE")
        @Expose
        private String lEAVEDATE;
        @SerializedName("ID")
        @Expose
        private String iD;
        @SerializedName("LEAVEEMPID")
        @Expose
        private String lEAVEEMPID;
        @SerializedName("LEAVESUBID")
        @Expose
        private String lEAVESUBID;
        @SerializedName("ISPROXYLECTURE")
        @Expose
        private Boolean iSPROXYLECTURE;
        @SerializedName("FULLNAME")
        @Expose
        private String fULLNAME;
        @SerializedName("EMPNAMEALIAS")
        @Expose
        private String eMPNAMEALIAS;
        @SerializedName("ROOMMASTERNAME")
        @Expose
        private String rOOMMASTERNAME;
        @SerializedName("SUBJECTNAME")
        @Expose
        private String sUBJECTNAME;
        @SerializedName("SUBALIAS")
        @Expose
        private String sUBALIAS;
        @SerializedName("EMPLOYEEID")
        @Expose
        private String eMPLOYEEID;
        @SerializedName("SUBJECTID")
        @Expose
        private String sUBJECTID;
        @SerializedName("LOCATIONNAME")
        @Expose
        private String lOCATIONNAME;
        @SerializedName("LOCATION1")
        @Expose
        private String lOCATION1;
        @SerializedName("ROOMALIASNAME")
        @Expose
        private String rOOMALIASNAME;
        @SerializedName("LOCALIASNAME")
        @Expose
        private String lOCALIASNAME;
        @SerializedName("EMPTIMESTATUS")
        @Expose
        private String eMPTIMESTATUS;
        @SerializedName("EMPLOYEESTATUS")
        @Expose
        private String eMPLOYEESTATUS;

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public Integer getLECTUREID() {
            return lECTUREID;
        }

        public void setLECTUREID(Integer lECTUREID) {
            this.lECTUREID = lECTUREID;
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

        public Integer getBATCHID() {
            return bATCHID;
        }

        public void setBATCHID(Integer bATCHID) {
            this.bATCHID = bATCHID;
        }

        public String getSECTIONID() {
            return sECTIONID;
        }

        public void setSECTIONID(String sECTIONID) {
            this.sECTIONID = sECTIONID;
        }

        public Integer getSUBID() {
            return sUBID;
        }

        public void setSUBID(Integer sUBID) {
            this.sUBID = sUBID;
        }

        public Integer getEMPID() {
            return eMPID;
        }

        public void setEMPID(Integer eMPID) {
            this.eMPID = eMPID;
        }

        public Integer getROOMID() {
            return rOOMID;
        }

        public void setROOMID(Integer rOOMID) {
            this.rOOMID = rOOMID;
        }

        public Integer getLABID() {
            return lABID;
        }

        public void setLABID(Integer lABID) {
            this.lABID = lABID;
        }

        public Integer getDIVISIONID() {
            return dIVISIONID;
        }

        public void setDIVISIONID(Integer dIVISIONID) {
            this.dIVISIONID = dIVISIONID;
        }

        public Integer getLOCATIONID() {
            return lOCATIONID;
        }

        public void setLOCATIONID(Integer lOCATIONID) {
            this.lOCATIONID = lOCATIONID;
        }

        public String getLABNAME() {
            return lABNAME;
        }

        public void setLABNAME(String lABNAME) {
            this.lABNAME = lABNAME;
        }

        public String getLABFULLNAME() {
            return lABFULLNAME;
        }

        public void setLABFULLNAME(String lABFULLNAME) {
            this.lABFULLNAME = lABFULLNAME;
        }

        public String getDIVISIONNAME() {
            return dIVISIONNAME;
        }

        public void setDIVISIONNAME(String dIVISIONNAME) {
            this.dIVISIONNAME = dIVISIONNAME;
        }

        public String getDIVISIONFULLNAME() {
            return dIVISIONFULLNAME;
        }

        public void setDIVISIONFULLNAME(String dIVISIONFULLNAME) {
            this.dIVISIONFULLNAME = dIVISIONFULLNAME;
        }

        public String getLOCNAME() {
            return lOCNAME;
        }

        public void setLOCNAME(String lOCNAME) {
            this.lOCNAME = lOCNAME;
        }

        public String getLOCATION() {
            return lOCATION;
        }

        public void setLOCATION(String lOCATION) {
            this.lOCATION = lOCATION;
        }

        public String getLABALIASNAME() {
            return lABALIASNAME;
        }

        public void setLABALIASNAME(String lABALIASNAME) {
            this.lABALIASNAME = lABALIASNAME;
        }

        public Integer getUSERID() {
            return uSERID;
        }

        public void setUSERID(Integer uSERID) {
            this.uSERID = uSERID;
        }

        public String getCLASSTIME() {
            return cLASSTIME;
        }

        public void setCLASSTIME(String cLASSTIME) {
            this.cLASSTIME = cLASSTIME;
        }

        public String getWEEKDAY() {
            return wEEKDAY;
        }

        public void setWEEKDAY(String wEEKDAY) {
            this.wEEKDAY = wEEKDAY;
        }

        public String getREMARKS() {
            return rEMARKS;
        }

        public void setREMARKS(String rEMARKS) {
            this.rEMARKS = rEMARKS;
        }

        public Integer getCLASSTIMEID() {
            return cLASSTIMEID;
        }

        public void setCLASSTIMEID(Integer cLASSTIMEID) {
            this.cLASSTIMEID = cLASSTIMEID;
        }

        public Integer getCOURSEID() {
            return cOURSEID;
        }

        public void setCOURSEID(Integer cOURSEID) {
            this.cOURSEID = cOURSEID;
        }

        public Integer getACADEMICID() {
            return aCADEMICID;
        }

        public void setACADEMICID(Integer aCADEMICID) {
            this.aCADEMICID = aCADEMICID;
        }

        public String getSTARTTIME() {
            return sTARTTIME;
        }

        public void setSTARTTIME(String sTARTTIME) {
            this.sTARTTIME = sTARTTIME;
        }

        public String getENDTIME() {
            return eNDTIME;
        }

        public void setENDTIME(String eNDTIME) {
            this.eNDTIME = eNDTIME;
        }

        public String getCLASSTIMING() {
            return cLASSTIMING;
        }

        public void setCLASSTIMING(String cLASSTIMING) {
            this.cLASSTIMING = cLASSTIMING;
        }

        public Boolean getMONDAY() {
            return mONDAY;
        }

        public void setMONDAY(Boolean mONDAY) {
            this.mONDAY = mONDAY;
        }

        public Boolean getTUESDAY() {
            return tUESDAY;
        }

        public void setTUESDAY(Boolean tUESDAY) {
            this.tUESDAY = tUESDAY;
        }

        public Boolean getWEDNESDAY() {
            return wEDNESDAY;
        }

        public void setWEDNESDAY(Boolean wEDNESDAY) {
            this.wEDNESDAY = wEDNESDAY;
        }

        public Boolean getTHURSEDAY() {
            return tHURSEDAY;
        }

        public void setTHURSEDAY(Boolean tHURSEDAY) {
            this.tHURSEDAY = tHURSEDAY;
        }

        public Boolean getFRIDAY() {
            return fRIDAY;
        }

        public void setFRIDAY(Boolean fRIDAY) {
            this.fRIDAY = fRIDAY;
        }

        public Boolean getSATURDAY() {
            return sATURDAY;
        }

        public void setSATURDAY(Boolean sATURDAY) {
            this.sATURDAY = sATURDAY;
        }

        public Boolean getSUNDAY() {
            return sUNDAY;
        }

        public void setSUNDAY(Boolean sUNDAY) {
            this.sUNDAY = sUNDAY;
        }

        public String getEMPFULLNAME() {
            return eMPFULLNAME;
        }

        public void setEMPFULLNAME(String eMPFULLNAME) {
            this.eMPFULLNAME = eMPFULLNAME;
        }

        public String getNAMEALIAS() {
            return nAMEALIAS;
        }

        public void setNAMEALIAS(String nAMEALIAS) {
            this.nAMEALIAS = nAMEALIAS;
        }

        public String getEMPTIMETABLETYPE() {
            return eMPTIMETABLETYPE;
        }

        public void setEMPTIMETABLETYPE(String eMPTIMETABLETYPE) {
            this.eMPTIMETABLETYPE = eMPTIMETABLETYPE;
        }

        public String getEMPSTATUS() {
            return eMPSTATUS;
        }

        public void setEMPSTATUS(String eMPSTATUS) {
            this.eMPSTATUS = eMPSTATUS;
        }

        public String getROMMNAME() {
            return rOMMNAME;
        }

        public void setROMMNAME(String rOMMNAME) {
            this.rOMMNAME = rOMMNAME;
        }

        public String getROOMALIAS() {
            return rOOMALIAS;
        }

        public void setROOMALIAS(String rOOMALIAS) {
            this.rOOMALIAS = rOOMALIAS;
        }

        public String getSUBNAME() {
            return sUBNAME;
        }

        public void setSUBNAME(String sUBNAME) {
            this.sUBNAME = sUBNAME;
        }

        public String getSUBJECTALIAS() {
            return sUBJECTALIAS;
        }

        public void setSUBJECTALIAS(String sUBJECTALIAS) {
            this.sUBJECTALIAS = sUBJECTALIAS;
        }

        public Boolean getISBREAK() {
            return iSBREAK;
        }

        public void setISBREAK(Boolean iSBREAK) {
            this.iSBREAK = iSBREAK;
        }

        public String getBATCHNAME() {
            return bATCHNAME;
        }

        public void setBATCHNAME(String bATCHNAME) {
            this.bATCHNAME = bATCHNAME;
        }

        public String getCOURSENAME() {
            return cOURSENAME;
        }

        public void setCOURSENAME(String cOURSENAME) {
            this.cOURSENAME = cOURSENAME;
        }

        public String getLEAVEDATE() {
            return lEAVEDATE;
        }

        public void setLEAVEDATE(String lEAVEDATE) {
            this.lEAVEDATE = lEAVEDATE;
        }

        public String getID() {
            return iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }

        public String getLEAVEEMPID() {
            return lEAVEEMPID;
        }

        public void setLEAVEEMPID(String lEAVEEMPID) {
            this.lEAVEEMPID = lEAVEEMPID;
        }

        public String getLEAVESUBID() {
            return lEAVESUBID;
        }

        public void setLEAVESUBID(String lEAVESUBID) {
            this.lEAVESUBID = lEAVESUBID;
        }

        public Boolean getISPROXYLECTURE() {
            return iSPROXYLECTURE;
        }

        public void setISPROXYLECTURE(Boolean iSPROXYLECTURE) {
            this.iSPROXYLECTURE = iSPROXYLECTURE;
        }

        public String getFULLNAME() {
            return fULLNAME;
        }

        public void setFULLNAME(String fULLNAME) {
            this.fULLNAME = fULLNAME;
        }

        public String getEMPNAMEALIAS() {
            return eMPNAMEALIAS;
        }

        public void setEMPNAMEALIAS(String eMPNAMEALIAS) {
            this.eMPNAMEALIAS = eMPNAMEALIAS;
        }

        public String getROOMMASTERNAME() {
            return rOOMMASTERNAME;
        }

        public void setROOMMASTERNAME(String rOOMMASTERNAME) {
            this.rOOMMASTERNAME = rOOMMASTERNAME;
        }

        public String getSUBJECTNAME() {
            return sUBJECTNAME;
        }

        public void setSUBJECTNAME(String sUBJECTNAME) {
            this.sUBJECTNAME = sUBJECTNAME;
        }

        public String getSUBALIAS() {
            return sUBALIAS;
        }

        public void setSUBALIAS(String sUBALIAS) {
            this.sUBALIAS = sUBALIAS;
        }

        public String getEMPLOYEEID() {
            return eMPLOYEEID;
        }

        public void setEMPLOYEEID(String eMPLOYEEID) {
            this.eMPLOYEEID = eMPLOYEEID;
        }

        public String getSUBJECTID() {
            return sUBJECTID;
        }

        public void setSUBJECTID(String sUBJECTID) {
            this.sUBJECTID = sUBJECTID;
        }

        public String getLOCATIONNAME() {
            return lOCATIONNAME;
        }

        public void setLOCATIONNAME(String lOCATIONNAME) {
            this.lOCATIONNAME = lOCATIONNAME;
        }

        public String getLOCATION1() {
            return lOCATION1;
        }

        public void setLOCATION1(String lOCATION1) {
            this.lOCATION1 = lOCATION1;
        }

        public String getROOMALIASNAME() {
            return rOOMALIASNAME;
        }

        public void setROOMALIASNAME(String rOOMALIASNAME) {
            this.rOOMALIASNAME = rOOMALIASNAME;
        }

        public String getLOCALIASNAME() {
            return lOCALIASNAME;
        }

        public void setLOCALIASNAME(String lOCALIASNAME) {
            this.lOCALIASNAME = lOCALIASNAME;
        }

        public String getEMPTIMESTATUS() {
            return eMPTIMESTATUS;
        }

        public void setEMPTIMESTATUS(String eMPTIMESTATUS) {
            this.eMPTIMESTATUS = eMPTIMESTATUS;
        }

        public String getEMPLOYEESTATUS() {
            return eMPLOYEESTATUS;
        }

        public void setEMPLOYEESTATUS(String eMPLOYEESTATUS) {
            this.eMPLOYEESTATUS = eMPLOYEESTATUS;
        }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getDAYNAME() {
        return DAYNAME;
    }

    public void setDAYNAME(String DAYNAME) {
        this.DAYNAME = DAYNAME;
    }

    public String getDAYID() {
        return DAYID;
    }

    public void setDAYID(String DAYID) {
        this.DAYID = DAYID;
    }

    public String getDISPLAYSTARTTIME() {
        return DISPLAYSTARTTIME;
    }

    public void setDISPLAYSTARTTIME(String DISPLAYSTARTTIME) {
        this.DISPLAYSTARTTIME = DISPLAYSTARTTIME;
    }

    public String getEMPROOMLABTYPE() {
        return EMPROOMLABTYPE;
    }

    public void setEMPROOMLABTYPE(String EMPROOMLABTYPE) {
        this.EMPROOMLABTYPE = EMPROOMLABTYPE;
    }
}

