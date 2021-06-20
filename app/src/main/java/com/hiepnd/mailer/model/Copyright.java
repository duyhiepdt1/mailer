
package com.hiepnd.mailer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Copyright {

    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("url")
    @Expose
    private String url;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Copyright withYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Copyright withUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return "Copyright{" +
                "year=" + year +
                ", url='" + url + '\'' +
                '}';
    }
}
