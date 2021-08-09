package com.systrack.admission.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookCategoryInformationPojo {
    @SerializedName("BookCategoryInformation")
    @Expose
    private List<BookCategoryInformation> bookCategoryInformation = null;

    public List<BookCategoryInformation> getBookCategoryInformation() {
        return bookCategoryInformation;
    }

    public void setBookCategoryInformation(List<BookCategoryInformation> bookCategoryInformation) {
        this.bookCategoryInformation = bookCategoryInformation;
    }
}
