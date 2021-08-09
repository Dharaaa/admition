package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoomCategoryInformationPojo {
    @SerializedName("RoomCategoryInformation")
    @Expose
    private List<RoomCategoryInformation> roomCategoryInformation = null;

    public List<RoomCategoryInformation> getRoomCategoryInformation() {
        return roomCategoryInformation;
    }

    public void setRoomCategoryInformation(List<RoomCategoryInformation> roomCategoryInformation) {
        this.roomCategoryInformation = roomCategoryInformation;
    }
}
