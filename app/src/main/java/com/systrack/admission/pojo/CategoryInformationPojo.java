package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryInformationPojo {
    @SerializedName("CategoryInformation")
    @Expose
    private List<CategoryInformation> categoryInformation = null;

    public List<CategoryInformation> getCategoryInformation() {
        return categoryInformation;
    }

    public void setCategoryInformation(List<CategoryInformation> categoryInformation) {
        this.categoryInformation = categoryInformation;
    }
}
