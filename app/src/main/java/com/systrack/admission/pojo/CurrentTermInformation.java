package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentTermInformation {

    @SerializedName("DisplayMessage")
    @Expose
    private String displayMessage;
    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("CONFIGID")
    @Expose
    private Integer cONFIGID;
    @SerializedName("COLLEGEID")
    @Expose
    private Integer cOLLEGEID;
    @SerializedName("COLLEGELOGO")
    @Expose
    private String cOLLEGELOGO;
    @SerializedName("RECEIPTLOGO")
    @Expose
    private String rECEIPTLOGO;
    @SerializedName("IDCARDLOGO")
    @Expose
    private Object iDCARDLOGO;
    @SerializedName("SMSMESSAGE")
    @Expose
    private String sMSMESSAGE;
    @SerializedName("EMAILMESSAGE")
    @Expose
    private String eMAILMESSAGE;
    @SerializedName("SEMESTER")
    @Expose
    private String sEMESTER;
    @SerializedName("COLLEGENAME")
    @Expose
    private String cOLLEGENAME;
    @SerializedName("COLLEGEADDRESS")
    @Expose
    private String cOLLEGEADDRESS;
    @SerializedName("COLLEGEPHONENO")
    @Expose
    private String cOLLEGEPHONENO;
    @SerializedName("COLLEGEREGNO")
    @Expose
    private String cOLLEGEREGNO;
    @SerializedName("COLLEGEEMAIL")
    @Expose
    private String cOLLEGEEMAIL;
    @SerializedName("ISADMISSIONOPEN")
    @Expose
    private Boolean iSADMISSIONOPEN;
    @SerializedName("REDIRECTURL")
    @Expose
    private String rEDIRECTURL;
    @SerializedName("KEY")
    @Expose
    private String kEY;
    @SerializedName("KEYHASH")
    @Expose
    private String kEYHASH;
    @SerializedName("ACTIVETERM")
    @Expose
    private Integer aCTIVETERM;
    @SerializedName("ISINTERNALCONFIG")
    @Expose
    private Boolean iSINTERNALCONFIG;
    @SerializedName("FEESRECEIPTNO")
    @Expose
    private Integer fEESRECEIPTNO;
    @SerializedName("ADMISSIONNO")
    @Expose
    private Integer aDMISSIONNO;
    @SerializedName("TERMDATE")
    @Expose
    private String tERMDATE;
    @SerializedName("ISQUICKVIEW")
    @Expose
    private Boolean iSQUICKVIEW;
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
    @SerializedName("SELFFINANCE_FEERECEIPTNO")
    @Expose
    private Integer sELFFINANCEFEERECEIPTNO;
    @SerializedName("SHORTURLPARAM")
    @Expose
    private String sHORTURLPARAM;
    @SerializedName("HELPLINEDETAILS")
    @Expose
    private Object hELPLINEDETAILS;
    @SerializedName("BRANCHID")
    @Expose
    private Integer bRANCHID;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getCONFIGID() {
        return cONFIGID;
    }

    public void setCONFIGID(Integer cONFIGID) {
        this.cONFIGID = cONFIGID;
    }

    public Integer getCOLLEGEID() {
        return cOLLEGEID;
    }

    public void setCOLLEGEID(Integer cOLLEGEID) {
        this.cOLLEGEID = cOLLEGEID;
    }

    public String getCOLLEGELOGO() {
        return cOLLEGELOGO;
    }

    public void setCOLLEGELOGO(String cOLLEGELOGO) {
        this.cOLLEGELOGO = cOLLEGELOGO;
    }

    public String getRECEIPTLOGO() {
        return rECEIPTLOGO;
    }

    public void setRECEIPTLOGO(String rECEIPTLOGO) {
        this.rECEIPTLOGO = rECEIPTLOGO;
    }

    public Object getIDCARDLOGO() {
        return iDCARDLOGO;
    }

    public void setIDCARDLOGO(Object iDCARDLOGO) {
        this.iDCARDLOGO = iDCARDLOGO;
    }

    public String getSMSMESSAGE() {
        return sMSMESSAGE;
    }

    public void setSMSMESSAGE(String sMSMESSAGE) {
        this.sMSMESSAGE = sMSMESSAGE;
    }

    public String getEMAILMESSAGE() {
        return eMAILMESSAGE;
    }

    public void setEMAILMESSAGE(String eMAILMESSAGE) {
        this.eMAILMESSAGE = eMAILMESSAGE;
    }

    public String getSEMESTER() {
        return sEMESTER;
    }

    public void setSEMESTER(String sEMESTER) {
        this.sEMESTER = sEMESTER;
    }

    public String getCOLLEGENAME() {
        return cOLLEGENAME;
    }

    public void setCOLLEGENAME(String cOLLEGENAME) {
        this.cOLLEGENAME = cOLLEGENAME;
    }

    public String getCOLLEGEADDRESS() {
        return cOLLEGEADDRESS;
    }

    public void setCOLLEGEADDRESS(String cOLLEGEADDRESS) {
        this.cOLLEGEADDRESS = cOLLEGEADDRESS;
    }

    public String getCOLLEGEPHONENO() {
        return cOLLEGEPHONENO;
    }

    public void setCOLLEGEPHONENO(String cOLLEGEPHONENO) {
        this.cOLLEGEPHONENO = cOLLEGEPHONENO;
    }

    public String getCOLLEGEREGNO() {
        return cOLLEGEREGNO;
    }

    public void setCOLLEGEREGNO(String cOLLEGEREGNO) {
        this.cOLLEGEREGNO = cOLLEGEREGNO;
    }

    public String getCOLLEGEEMAIL() {
        return cOLLEGEEMAIL;
    }

    public void setCOLLEGEEMAIL(String cOLLEGEEMAIL) {
        this.cOLLEGEEMAIL = cOLLEGEEMAIL;
    }

    public Boolean getISADMISSIONOPEN() {
        return iSADMISSIONOPEN;
    }

    public void setISADMISSIONOPEN(Boolean iSADMISSIONOPEN) {
        this.iSADMISSIONOPEN = iSADMISSIONOPEN;
    }

    public String getREDIRECTURL() {
        return rEDIRECTURL;
    }

    public void setREDIRECTURL(String rEDIRECTURL) {
        this.rEDIRECTURL = rEDIRECTURL;
    }

    public String getKEY() {
        return kEY;
    }

    public void setKEY(String kEY) {
        this.kEY = kEY;
    }

    public String getKEYHASH() {
        return kEYHASH;
    }

    public void setKEYHASH(String kEYHASH) {
        this.kEYHASH = kEYHASH;
    }

    public Integer getACTIVETERM() {
        return aCTIVETERM;
    }

    public void setACTIVETERM(Integer aCTIVETERM) {
        this.aCTIVETERM = aCTIVETERM;
    }

    public Boolean getISINTERNALCONFIG() {
        return iSINTERNALCONFIG;
    }

    public void setISINTERNALCONFIG(Boolean iSINTERNALCONFIG) {
        this.iSINTERNALCONFIG = iSINTERNALCONFIG;
    }

    public Integer getFEESRECEIPTNO() {
        return fEESRECEIPTNO;
    }

    public void setFEESRECEIPTNO(Integer fEESRECEIPTNO) {
        this.fEESRECEIPTNO = fEESRECEIPTNO;
    }

    public Integer getADMISSIONNO() {
        return aDMISSIONNO;
    }

    public void setADMISSIONNO(Integer aDMISSIONNO) {
        this.aDMISSIONNO = aDMISSIONNO;
    }

    public String getTERMDATE() {
        return tERMDATE;
    }

    public void setTERMDATE(String tERMDATE) {
        this.tERMDATE = tERMDATE;
    }

    public Boolean getISQUICKVIEW() {
        return iSQUICKVIEW;
    }

    public void setISQUICKVIEW(Boolean iSQUICKVIEW) {
        this.iSQUICKVIEW = iSQUICKVIEW;
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

    public Integer getSELFFINANCEFEERECEIPTNO() {
        return sELFFINANCEFEERECEIPTNO;
    }

    public void setSELFFINANCEFEERECEIPTNO(Integer sELFFINANCEFEERECEIPTNO) {
        this.sELFFINANCEFEERECEIPTNO = sELFFINANCEFEERECEIPTNO;
    }

    public String getSHORTURLPARAM() {
        return sHORTURLPARAM;
    }

    public void setSHORTURLPARAM(String sHORTURLPARAM) {
        this.sHORTURLPARAM = sHORTURLPARAM;
    }

    public Object getHELPLINEDETAILS() {
        return hELPLINEDETAILS;
    }

    public void setHELPLINEDETAILS(Object hELPLINEDETAILS) {
        this.hELPLINEDETAILS = hELPLINEDETAILS;
    }

    public Integer getBRANCHID() {
        return bRANCHID;
    }

    public void setBRANCHID(Integer bRANCHID) {
        this.bRANCHID = bRANCHID;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
