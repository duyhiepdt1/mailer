
package com.hiepnd.mailer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class QuoteResponse {

    @SerializedName("success")
    @Expose
    private Success success;
    @SerializedName("contents")
    @Expose
    private Contents contents;
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

    public QuoteResponse withSuccess(Success success) {
        this.success = success;
        return this;
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    public QuoteResponse withContents(Contents contents) {
        this.contents = contents;
        return this;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public QuoteResponse withBaseurl(String baseurl) {
        this.baseurl = baseurl;
        return this;
    }

    public Copyright getCopyright() {
        return copyright;
    }

    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
    }

    public QuoteResponse withCopyright(Copyright copyright) {
        this.copyright = copyright;
        return this;
    }

}
