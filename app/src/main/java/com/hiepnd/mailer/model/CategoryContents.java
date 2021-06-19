
package com.hiepnd.mailer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;


public class CategoryContents {

    @SerializedName("categories")
    @Expose
    private HashMap categories;

    public HashMap getCategories() {
        return categories;
    }

    public void setCategories(HashMap categories) {
        this.categories = categories;
    }

    public CategoryContents withCategories(HashMap categories) {
        this.categories = categories;
        return this;
    }

}
