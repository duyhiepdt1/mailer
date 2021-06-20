
package com.hiepnd.mailer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quote {

    @SerializedName("quote")
    @Expose
    private String quote;
    @SerializedName("length")
    @Expose
    private String length;

    public Quote(String title, String quote, String author) {
        this.title = title;
        this.quote = quote;
        this.author = author;
    }

    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("background")
    @Expose
    private String background;
    @SerializedName("title")
    @Expose
    private String title;

    public Quote() {

    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Quote withQuote(String quote) {
        this.quote = quote;
        return this;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Quote withLength(String length) {
        this.length = length;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Quote withAuthor(String author) {
        this.author = author;
        return this;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Quote withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Quote withCategory(String category) {
        this.category = category;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Quote withLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Quote withDate(String date) {
        this.date = date;
        return this;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Quote withPermalink(String permalink) {
        this.permalink = permalink;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Quote withId(String id) {
        this.id = id;
        return this;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Quote withBackground(String background) {
        this.background = background;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Quote withTitle(String title) {
        this.title = title;
        return this;
    }

}
