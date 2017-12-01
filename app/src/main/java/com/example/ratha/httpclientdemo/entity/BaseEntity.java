package com.example.ratha.httpclientdemo.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ratha on 11/29/2017.
 */

public class BaseEntity {
    @SerializedName("code") String code;
    @SerializedName("status") boolean status;
    @SerializedName("smg") String smg;

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
}
