package com.example.ratha.httpclientdemo.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ratha on 11/29/2017.
 */

public class CategoryCreate extends  BaseEntity{

    @SerializedName("id")
    public int id;
    @SerializedName("keywords")
    public List<String> keywords;
    @SerializedName("cate_name")
    public String cate_name;
    @SerializedName("des")
    public String des;
    @SerializedName("icon_name")
    public String icon_name;
    @SerializedName("main_cate")
    public String main_cate;

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

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getIcon_name() {
        return icon_name;
    }

    public void setIcon_name(String icon_name) {
        this.icon_name = icon_name;
    }

    public String getMain_cate() {
        return main_cate;
    }

    public void setMain_cate(String main_cate) {
        this.main_cate = main_cate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", status=" + status +
                ", keywords=" + keywords +
                ", cate_name='" + cate_name + '\'' +
                ", des='" + des + '\'' +
                ", icon_name='" + icon_name + '\'' +
                ", main_cate='" + main_cate + '\'' +
                '}';
    }
}
