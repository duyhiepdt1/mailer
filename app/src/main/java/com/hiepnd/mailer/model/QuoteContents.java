
package com.hiepnd.mailer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuoteContents {

    @SerializedName("quotes")
    @Expose
    private List<Quote> quotes = null;

    public QuoteContents(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public QuoteContents() {

    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public QuoteContents withQuotes(List<Quote> quotes) {
        this.quotes = quotes;
        return this;
    }

    @Override
    public String toString() {
        return "QuoteContents{" +
                "quotes=" + quotes +
                '}';
    }
}
