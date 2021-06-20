
package com.hiepnd.mailer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Success {

    @SerializedName("total")
    @Expose
    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Success withTotal(Integer total) {
        this.total = total;
        return this;
    }

    @Override
    public String toString() {
        return "Success{" +
                "total=" + total +
                '}';
    }
}
