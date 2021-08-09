package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessageInformationPojo {
    @SerializedName("MessageInformation")
    @Expose
    private List<MessageInformation> messageInformation = null;

    public List<MessageInformation> getMessageInformation() {
        return messageInformation;
    }

    public void setMessageInformation(List<MessageInformation> messageInformation) {
        this.messageInformation = messageInformation;
    }
}
