package com.example.ratha.httpclientdemo.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ratha on 11/29/2017.
 */

public class CategoryPostResponse extends  BaseEntity{

    @SerializedName("data")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "CategoryPostResponse{" +
                "code='" + code + '\'' +
                ", status=" + status +
                ", smg='" + smg + '\'' +
                ", category=" + category +
                '}';
    }
}
