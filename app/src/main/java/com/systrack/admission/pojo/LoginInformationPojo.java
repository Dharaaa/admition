package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginInformationPojo {
    @SerializedName("LoginInformation")
    @Expose
    private List<LoginInformation> loginInformation = null;

    public List<LoginInformation> getLoginInformation() {
        return loginInformation;
    }

    public void setLoginInformation(List<LoginInformation> loginInformation) {
        this.loginInformation = loginInformation;
    }
}