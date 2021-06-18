
package com.hiepnd.mailer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Contents {

    @SerializedName("quotes")
    @Expose
    private List<Quote> quotes = null;

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public Contents withQuotes(List<Quote> quotes) {
        this.quotes = quotes;
        return this;
    }

}
