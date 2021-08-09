package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginInformation {

    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;
    @SerializedName("EMPTIMETABLETYPE")
    @Expose
    private Integer EMPTIMETABLETYPE;


    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("USERID")
    @Expose
    private Integer uSERID;
    @SerializedName("USERNAME")
    @Expose
    private String uSERNAME;
    @SerializedName("COLLEGEID")
    @Expose
    private Integer cOLLEGEID;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;
    @SerializedName("ROLEID")
    @Expose
    private Integer rOLEID;
    @SerializedName("FAILATTEMPT")
    @Expose
    private Integer fAILATTEMPT;
    @SerializedName("USERTYPE")
    @Expose
    private Object uSERTYPE;
    @SerializedName("LASTLOGIN")
    @Expose
    private String lASTLOGIN;
    @SerializedName("STATUS")
    @Expose
    private Boolean sTATUS;
    @SerializedName("FIRSTTIMELOGIN")
    @Expose
    private Boolean fIRSTTIMELOGIN;
    @SerializedName("FULLNAME")
    @Expose
    private String fULLNAME;
    @SerializedName("LANDING_PAGE")
    @Expose
    private String lANDINGPAGE;
    @SerializedName("EMAIL")
    @Expose
    private String eMAIL;
    @SerializedName("PROFILEURL")
    @Expose
    private String pROFILEURL;
    @SerializedName("COLID")
    @Expose
    private Integer cOLID;
    @SerializedName("COLLEGENAME")
    @Expose
    private String cOLLEGENAME;
    @SerializedName("ISMULTIPLEBRANCH")
    @Expose
    private Boolean iSMULTIPLEBRANCH;
    @SerializedName("ALLOWQUOTA")
    @Expose
    private Boolean aLLOWQUOTA;
    @SerializedName("SUBJECTTYPE")
    @Expose
    private Boolean sUBJECTTYPE;
    @SerializedName("FEEMASTERCONFIG")
    @Expose
    private Boolean fEEMASTERCONFIG;
    @SerializedName("SUBMASTERCONFIG")
    @Expose
    private Boolean sUBMASTERCONFIG;
    @SerializedName("ISADMISSIONCONFIG")
    @Expose
    private Boolean iSADMISSIONCONFIG;
    @SerializedName("ISINTERNALCONFIG")
    @Expose
    private Boolean iSINTERNALCONFIG;
    @SerializedName("ISGROUPBY")
    @Expose
    private Boolean iSGROUPBY;
    @SerializedName("ISQUICKVIEW")
    @Expose
    private Boolean iSQUICKVIEW;
    @SerializedName("ISPAYROLLCONFIG")
    @Expose
    private Boolean iSPAYROLLCONFIG;
    @SerializedName("PAYROLLURL")
    @Expose
    private String pAYROLLURL;
    @SerializedName("ISPAYMENTCONFIG")
    @Expose
    private Boolean iSPAYMENTCONFIG;
    @SerializedName("ISWHITELABLE")
    @Expose
    private Boolean iSWHITELABLE;
    @SerializedName("COMPANYNAME")
    @Expose
    private String cOMPANYNAME;
    @SerializedName("COMPANYURL")
    @Expose
    private String cOMPANYURL;
    @SerializedName("ISSTUDENTREGISTRATION")
    @Expose
    private Boolean iSSTUDENTREGISTRATION;
    @SerializedName("ISGENERATENEWRECEIPTNO")
    @Expose
    private Boolean iSGENERATENEWRECEIPTNO;
    @SerializedName("ISGETSTUDENTPASSOUTMARKS")
    @Expose
    private Boolean iSGETSTUDENTPASSOUTMARKS;
    @SerializedName("ISCATEGORYWISEFEESSTRUCTURE")
    @Expose
    private Boolean iSCATEGORYWISEFEESSTRUCTURE;
    @SerializedName("ISCUSTOMCLASS")
    @Expose
    private Boolean iSCUSTOMCLASS;
    @SerializedName("ISSELFFINANCEENABLED")
    @Expose
    private Boolean iSSELFFINANCEENABLED;
    @SerializedName("ISFILEUPLOADREQUIRE")
    @Expose
    private Boolean iSFILEUPLOADREQUIRE;
    @SerializedName("ISMISCELLANEOUSFEEENABLED")
    @Expose
    private Boolean iSMISCELLANEOUSFEEENABLED;
    @SerializedName("RESETROLLNOENABLE")
    @Expose
    private Boolean rESETROLLNOENABLE;
    @SerializedName("COLLEGETYPE")
    @Expose
    private String cOLLEGETYPE;
    @SerializedName("SCIENCECOLLEGETYPE")
    @Expose
    private String sCIENCECOLLEGETYPE;
    @SerializedName("ISENABLEERP")
    @Expose
    private Boolean iSENABLEERP;
    @SerializedName("ISALLOWBATCH")
    @Expose
    private Boolean iSALLOWBATCH;
    @SerializedName("ISALLOWDIVISION")
    @Expose
    private Boolean iSALLOWDIVISION;
    @SerializedName("ISSTUDENTLOGIN")
    @Expose
    private Boolean iSSTUDENTLOGIN;
    @SerializedName("ISEMPLOYEELOGIN")
    @Expose
    private Boolean iSEMPLOYEELOGIN;
    @SerializedName("IsREGISTERAUTOINCREMENT")
    @Expose
    private Boolean isREGISTERAUTOINCREMENT;
    @SerializedName("ISSECONDFECTOR")
    @Expose
    private Boolean iSSECONDFECTOR;
    @SerializedName("ISNOTIFY")
    @Expose
    private Boolean iSNOTIFY;
    @SerializedName("ENABLEPRACTICAL")
    @Expose
    private Boolean eNABLEPRACTICAL;
    @SerializedName("ISGROUPWISE")
    @Expose
    private String iSGROUPWISE;
    @SerializedName("ROLENAME")
    @Expose
    private String rOLENAME;
    @SerializedName("EMPLOYEEID")
    @Expose
    private Integer eMPLOYEEID;
    @SerializedName("EMPLOYEENO")
    @Expose
    private Object eMPLOYEENO;
    @SerializedName("CATEGORYID")
    @Expose
    private Object cATEGORYID;
    @SerializedName("EMPFULLNAME")
    @Expose
    private Object eMPFULLNAME;
    @SerializedName("EMPPROFILEURL")
    @Expose
    private String eMPPROFILEURL;
    @SerializedName("COURSEID")
    @Expose
    private Object cOURSEID;
    @SerializedName("MEDIUM")
    @Expose
    private Object mEDIUM;
    @SerializedName("ISNOTIFYATTENDANCE")
    @Expose
    private Boolean iSNOTIFYATTENDANCE;
    @SerializedName("COLLEGEID1")
    @Expose
    private Integer cOLLEGEID1;
    @SerializedName("BRANCHNAME")
    @Expose
    private String bRANCHNAME;
    @SerializedName("BRANCHCODE")
    @Expose
    private String bRANCHCODE;
    @SerializedName("BRANCHADDRESS")
    @Expose
    private String bRANCHADDRESS;
    @SerializedName("BRANCHPHONENO")
    @Expose
    private String bRANCHPHONENO;

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getUSERID() {
        return uSERID;
    }

    public void setUSERID(Integer uSERID) {
        this.uSERID = uSERID;
    }

    public String getUSERNAME() {
        return uSERNAME;
    }

    public void setUSERNAME(String uSERNAME) {
        this.uSERNAME = uSERNAME;
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

    public Integer getROLEID() {
        return rOLEID;
    }

    public void setROLEID(Integer rOLEID) {
        this.rOLEID = rOLEID;
    }

    public Integer getFAILATTEMPT() {
        return fAILATTEMPT;
    }

    public void setFAILATTEMPT(Integer fAILATTEMPT) {
        this.fAILATTEMPT = fAILATTEMPT;
    }

    public Object getUSERTYPE() {
        return uSERTYPE;
    }

    public void setUSERTYPE(Object uSERTYPE) {
        this.uSERTYPE = uSERTYPE;
    }

    public String getLASTLOGIN() {
        return lASTLOGIN;
    }

    public void setLASTLOGIN(String lASTLOGIN) {
        this.lASTLOGIN = lASTLOGIN;
    }

    public Boolean getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(Boolean sTATUS) {
        this.sTATUS = sTATUS;
    }

    public Boolean getFIRSTTIMELOGIN() {
        return fIRSTTIMELOGIN;
    }

    public void setFIRSTTIMELOGIN(Boolean fIRSTTIMELOGIN) {
        this.fIRSTTIMELOGIN = fIRSTTIMELOGIN;
    }

    public String getFULLNAME() {
        return fULLNAME;
    }

    public void setFULLNAME(String fULLNAME) {
        this.fULLNAME = fULLNAME;
    }

    public String getLANDINGPAGE() {
        return lANDINGPAGE;
    }

    public void setLANDINGPAGE(String lANDINGPAGE) {
        this.lANDINGPAGE = lANDINGPAGE;
    }

    public String getEMAIL() {
        return eMAIL;
    }

    public void setEMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public String getPROFILEURL() {
        return pROFILEURL;
    }

    public void setPROFILEURL(String pROFILEURL) {
        this.pROFILEURL = pROFILEURL;
    }

    public Integer getCOLID() {
        return cOLID;
    }

    public void setCOLID(Integer cOLID) {
        this.cOLID = cOLID;
    }

    public String getCOLLEGENAME() {
        return cOLLEGENAME;
    }

    public void setCOLLEGENAME(String cOLLEGENAME) {
        this.cOLLEGENAME = cOLLEGENAME;
    }

    public Boolean getISMULTIPLEBRANCH() {
        return iSMULTIPLEBRANCH;
    }

    public void setISMULTIPLEBRANCH(Boolean iSMULTIPLEBRANCH) {
        this.iSMULTIPLEBRANCH = iSMULTIPLEBRANCH;
    }

    public Boolean getALLOWQUOTA() {
        return aLLOWQUOTA;
    }

    public void setALLOWQUOTA(Boolean aLLOWQUOTA) {
        this.aLLOWQUOTA = aLLOWQUOTA;
    }

    public Boolean getSUBJECTTYPE() {
        return sUBJECTTYPE;
    }

    public void setSUBJECTTYPE(Boolean sUBJECTTYPE) {
        this.sUBJECTTYPE = sUBJECTTYPE;
    }

    public Boolean getFEEMASTERCONFIG() {
        return fEEMASTERCONFIG;
    }

    public void setFEEMASTERCONFIG(Boolean fEEMASTERCONFIG) {
        this.fEEMASTERCONFIG = fEEMASTERCONFIG;
    }

    public Boolean getSUBMASTERCONFIG() {
        return sUBMASTERCONFIG;
    }

    public void setSUBMASTERCONFIG(Boolean sUBMASTERCONFIG) {
        this.sUBMASTERCONFIG = sUBMASTERCONFIG;
    }

    public Boolean getISADMISSIONCONFIG() {
        return iSADMISSIONCONFIG;
    }

    public void setISADMISSIONCONFIG(Boolean iSADMISSIONCONFIG) {
        this.iSADMISSIONCONFIG = iSADMISSIONCONFIG;
    }

    public Boolean getISINTERNALCONFIG() {
        return iSINTERNALCONFIG;
    }

    public void setISINTERNALCONFIG(Boolean iSINTERNALCONFIG) {
        this.iSINTERNALCONFIG = iSINTERNALCONFIG;
    }

    public Boolean getISGROUPBY() {
        return iSGROUPBY;
    }

    public void setISGROUPBY(Boolean iSGROUPBY) {
        this.iSGROUPBY = iSGROUPBY;
    }

    public Boolean getISQUICKVIEW() {
        return iSQUICKVIEW;
    }

    public void setISQUICKVIEW(Boolean iSQUICKVIEW) {
        this.iSQUICKVIEW = iSQUICKVIEW;
    }

    public Boolean getISPAYROLLCONFIG() {
        return iSPAYROLLCONFIG;
    }

    public void setISPAYROLLCONFIG(Boolean iSPAYROLLCONFIG) {
        this.iSPAYROLLCONFIG = iSPAYROLLCONFIG;
    }

    public String getPAYROLLURL() {
        return pAYROLLURL;
    }

    public void setPAYROLLURL(String pAYROLLURL) {
        this.pAYROLLURL = pAYROLLURL;
    }

    public Boolean getISPAYMENTCONFIG() {
        return iSPAYMENTCONFIG;
    }

    public void setISPAYMENTCONFIG(Boolean iSPAYMENTCONFIG) {
        this.iSPAYMENTCONFIG = iSPAYMENTCONFIG;
    }

    public Boolean getISWHITELABLE() {
        return iSWHITELABLE;
    }

    public void setISWHITELABLE(Boolean iSWHITELABLE) {
        this.iSWHITELABLE = iSWHITELABLE;
    }

    public String getCOMPANYNAME() {
        return cOMPANYNAME;
    }

    public void setCOMPANYNAME(String cOMPANYNAME) {
        this.cOMPANYNAME = cOMPANYNAME;
    }

    public String getCOMPANYURL() {
        return cOMPANYURL;
    }

    public void setCOMPANYURL(String cOMPANYURL) {
        this.cOMPANYURL = cOMPANYURL;
    }

    public Boolean getISSTUDENTREGISTRATION() {
        return iSSTUDENTREGISTRATION;
    }

    public void setISSTUDENTREGISTRATION(Boolean iSSTUDENTREGISTRATION) {
        this.iSSTUDENTREGISTRATION = iSSTUDENTREGISTRATION;
    }

    public Boolean getISGENERATENEWRECEIPTNO() {
        return iSGENERATENEWRECEIPTNO;
    }

    public void setISGENERATENEWRECEIPTNO(Boolean iSGENERATENEWRECEIPTNO) {
        this.iSGENERATENEWRECEIPTNO = iSGENERATENEWRECEIPTNO;
    }

    public Boolean getISGETSTUDENTPASSOUTMARKS() {
        return iSGETSTUDENTPASSOUTMARKS;
    }

    public void setISGETSTUDENTPASSOUTMARKS(Boolean iSGETSTUDENTPASSOUTMARKS) {
        this.iSGETSTUDENTPASSOUTMARKS = iSGETSTUDENTPASSOUTMARKS;
    }

    public Boolean getISCATEGORYWISEFEESSTRUCTURE() {
        return iSCATEGORYWISEFEESSTRUCTURE;
    }

    public void setISCATEGORYWISEFEESSTRUCTURE(Boolean iSCATEGORYWISEFEESSTRUCTURE) {
        this.iSCATEGORYWISEFEESSTRUCTURE = iSCATEGORYWISEFEESSTRUCTURE;
    }

    public Boolean getISCUSTOMCLASS() {
        return iSCUSTOMCLASS;
    }

    public void setISCUSTOMCLASS(Boolean iSCUSTOMCLASS) {
        this.iSCUSTOMCLASS = iSCUSTOMCLASS;
    }

    public Boolean getISSELFFINANCEENABLED() {
        return iSSELFFINANCEENABLED;
    }

    public void setISSELFFINANCEENABLED(Boolean iSSELFFINANCEENABLED) {
        this.iSSELFFINANCEENABLED = iSSELFFINANCEENABLED;
    }

    public Boolean getISFILEUPLOADREQUIRE() {
        return iSFILEUPLOADREQUIRE;
    }

    public void setISFILEUPLOADREQUIRE(Boolean iSFILEUPLOADREQUIRE) {
        this.iSFILEUPLOADREQUIRE = iSFILEUPLOADREQUIRE;
    }

    public Boolean getISMISCELLANEOUSFEEENABLED() {
        return iSMISCELLANEOUSFEEENABLED;
    }

    public void setISMISCELLANEOUSFEEENABLED(Boolean iSMISCELLANEOUSFEEENABLED) {
        this.iSMISCELLANEOUSFEEENABLED = iSMISCELLANEOUSFEEENABLED;
    }

    public Boolean getRESETROLLNOENABLE() {
        return rESETROLLNOENABLE;
    }

    public void setRESETROLLNOENABLE(Boolean rESETROLLNOENABLE) {
        this.rESETROLLNOENABLE = rESETROLLNOENABLE;
    }

    public String getCOLLEGETYPE() {
        return cOLLEGETYPE;
    }

    public void setCOLLEGETYPE(String cOLLEGETYPE) {
        this.cOLLEGETYPE = cOLLEGETYPE;
    }

    public String getSCIENCECOLLEGETYPE() {
        return sCIENCECOLLEGETYPE;
    }

    public void setSCIENCECOLLEGETYPE(String sCIENCECOLLEGETYPE) {
        this.sCIENCECOLLEGETYPE = sCIENCECOLLEGETYPE;
    }

    public Boolean getISENABLEERP() {
        return iSENABLEERP;
    }

    public void setISENABLEERP(Boolean iSENABLEERP) {
        this.iSENABLEERP = iSENABLEERP;
    }

    public Boolean getISALLOWBATCH() {
        return iSALLOWBATCH;
    }

    public void setISALLOWBATCH(Boolean iSALLOWBATCH) {
        this.iSALLOWBATCH = iSALLOWBATCH;
    }

    public Boolean getISALLOWDIVISION() {
        return iSALLOWDIVISION;
    }

    public void setISALLOWDIVISION(Boolean iSALLOWDIVISION) {
        this.iSALLOWDIVISION = iSALLOWDIVISION;
    }

    public Boolean getISSTUDENTLOGIN() {
        return iSSTUDENTLOGIN;
    }

    public void setISSTUDENTLOGIN(Boolean iSSTUDENTLOGIN) {
        this.iSSTUDENTLOGIN = iSSTUDENTLOGIN;
    }

    public Boolean getISEMPLOYEELOGIN() {
        return iSEMPLOYEELOGIN;
    }

    public void setISEMPLOYEELOGIN(Boolean iSEMPLOYEELOGIN) {
        this.iSEMPLOYEELOGIN = iSEMPLOYEELOGIN;
    }

    public Boolean getIsREGISTERAUTOINCREMENT() {
        return isREGISTERAUTOINCREMENT;
    }

    public void setIsREGISTERAUTOINCREMENT(Boolean isREGISTERAUTOINCREMENT) {
        this.isREGISTERAUTOINCREMENT = isREGISTERAUTOINCREMENT;
    }

    public Boolean getISSECONDFECTOR() {
        return iSSECONDFECTOR;
    }

    public void setISSECONDFECTOR(Boolean iSSECONDFECTOR) {
        this.iSSECONDFECTOR = iSSECONDFECTOR;
    }

    public Boolean getISNOTIFY() {
        return iSNOTIFY;
    }

    public void setISNOTIFY(Boolean iSNOTIFY) {
        this.iSNOTIFY = iSNOTIFY;
    }

    public Boolean getENABLEPRACTICAL() {
        return eNABLEPRACTICAL;
    }

    public void setENABLEPRACTICAL(Boolean eNABLEPRACTICAL) {
        this.eNABLEPRACTICAL = eNABLEPRACTICAL;
    }

    public String getISGROUPWISE() {
        return iSGROUPWISE;
    }

    public void setISGROUPWISE(String iSGROUPWISE) {
        this.iSGROUPWISE = iSGROUPWISE;
    }

    public String getROLENAME() {
        return rOLENAME;
    }

    public void setROLENAME(String rOLENAME) {
        this.rOLENAME = rOLENAME;
    }

    public Integer getEMPLOYEEID() {
        return eMPLOYEEID;
    }

    public void setEMPLOYEEID(Integer eMPLOYEEID) {
        this.eMPLOYEEID = eMPLOYEEID;
    }

    public Object getEMPLOYEENO() {
        return eMPLOYEENO;
    }

    public void setEMPLOYEENO(Object eMPLOYEENO) {
        this.eMPLOYEENO = eMPLOYEENO;
    }

    public Object getCATEGORYID() {
        return cATEGORYID;
    }

    public void setCATEGORYID(Object cATEGORYID) {
        this.cATEGORYID = cATEGORYID;
    }

    public Object getEMPFULLNAME() {
        return eMPFULLNAME;
    }

    public void setEMPFULLNAME(Object eMPFULLNAME) {
        this.eMPFULLNAME = eMPFULLNAME;
    }

    public String getEMPPROFILEURL() {
        return eMPPROFILEURL;
    }

    public void setEMPPROFILEURL(String eMPPROFILEURL) {
        this.eMPPROFILEURL = eMPPROFILEURL;
    }

    public Object getCOURSEID() {
        return cOURSEID;
    }

    public void setCOURSEID(Object cOURSEID) {
        this.cOURSEID = cOURSEID;
    }

    public Object getMEDIUM() {
        return mEDIUM;
    }

    public void setMEDIUM(Object mEDIUM) {
        this.mEDIUM = mEDIUM;
    }

    public Boolean getISNOTIFYATTENDANCE() {
        return iSNOTIFYATTENDANCE;
    }

    public void setISNOTIFYATTENDANCE(Boolean iSNOTIFYATTENDANCE) {
        this.iSNOTIFYATTENDANCE = iSNOTIFYATTENDANCE;
    }

    public Integer getCOLLEGEID1() {
        return cOLLEGEID1;
    }

    public void setCOLLEGEID1(Integer cOLLEGEID1) {
        this.cOLLEGEID1 = cOLLEGEID1;
    }

    public String getBRANCHNAME() {
        return bRANCHNAME;
    }

    public void setBRANCHNAME(String bRANCHNAME) {
        this.bRANCHNAME = bRANCHNAME;
    }

    public String getBRANCHCODE() {
        return bRANCHCODE;
    }

    public void setBRANCHCODE(String bRANCHCODE) {
        this.bRANCHCODE = bRANCHCODE;
    }

    public String getBRANCHADDRESS() {
        return bRANCHADDRESS;
    }

    public void setBRANCHADDRESS(String bRANCHADDRESS) {
        this.bRANCHADDRESS = bRANCHADDRESS;
    }

    public String getBRANCHPHONENO() {
        return bRANCHPHONENO;
    }

    public void setBRANCHPHONENO(String bRANCHPHONENO) {
        this.bRANCHPHONENO = bRANCHPHONENO;
    }

    public Integer getEMPTIMETABLETYPE() {
        return EMPTIMETABLETYPE;
    }

    public void setEMPTIMETABLETYPE(Integer EMPTIMETABLETYPE) {
        this.EMPTIMETABLETYPE = EMPTIMETABLETYPE;
    }
}
