package com.example.ratha.httpclientdemo.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ratha on 11/29/2017.
 */

public class CategoryUpdate {

    @SerializedName("code")
    public String code;
    @SerializedName("status")
    public boolean status;
    @SerializedName("msg")
    public String msg;
    @SerializedName("data")
    public Category category;

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
