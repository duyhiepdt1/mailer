package com.hiepnd.mailer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryResponse {

    @SerializedName("success")
    @Expose
    private Success success;
    @SerializedName("contents")
    @Expose
    private CategoryContents categoryContents;
    @SerializedName("baseurl")
    @Expose
    private String baseurl;
    @SerializedName("copyright")
    @Expose
    private Copyright copyright;

    public Success getSuccess() {
        return success;
    }

    public void setSuccess(Success success) {
        this.success = success;
    }

    public CategoryResponse withSuccess(Success success) {
        this.success = success;
        return this;
    }

    public CategoryContents getCategoryContents() {
        return categoryContents;
    }

    public void setCategoryContents(CategoryContents categoryContents) {
        this.categoryContents = categoryContents;
    }

    public CategoryResponse withContents(CategoryContents categoryContents) {
        this.categoryContents = categoryContents;
        return this;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public CategoryResponse withBaseurl(String baseurl) {
        this.baseurl = baseurl;
        return this;
    }

    public Copyright getCopyright() {
        return copyright;
    }

    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
    }

    public CategoryResponse withCopyright(Copyright copyright) {
        this.copyright = copyright;
        return this;
    }

}

