package com.example.ratha.httpclientdemo.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ratha on 11/29/2017.
 */

public class Keyword {
    @SerializedName("id")
    public int id;
    @SerializedName("status")
    public boolean status;
    @SerializedName("keyword_name")
    public String keyword_name;
    @SerializedName("cate_id")
    public String cate_id;

    public Keyword(String keyword_name) {
        this.keyword_name = keyword_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getKeyword_name() {
        return keyword_name;
    }

    public void setKeyword_name(String keyword_name) {
        this.keyword_name = keyword_name;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id=" + id +
                ", status=" + status +
                ", keyword_name='" + keyword_name + '\'' +
                ", cate_id='" + cate_id + '\'' +
                '}';
    }
}
