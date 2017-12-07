package com.example.ratha.httpclientdemo.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ratha on 12/7/2017.
 */

public class CategoryCreateResponseObservable{
    @SerializedName("code") String code;
    @SerializedName("status") boolean status;
    @SerializedName("msg") String smg;
    @SerializedName("data")
    CategoryCreate category;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSmg() {
        return smg;
    }

    public void setSmg(String smg) {
        this.smg = smg;
    }

    public CategoryCreate getCategory() {
        return category;
    }

    public void setCategory(CategoryCreate category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "CategoryCreateResponseObservable{" +
                "code='" + code + '\'' +
                ", status=" + status +
                ", category=" + category +
                ", smg='" + smg + '\'' +
                '}';
    }
}
