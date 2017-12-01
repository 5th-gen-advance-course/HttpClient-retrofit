package com.example.ratha.httpclientdemo.entity;

/**
 * Created by ratha on 11/29/2017.
 */

public class SubCategory {

    public int id;
    public boolean status;
    public String cate_name;
    public String des;
    public String icon_name;
    public int total_url;

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

    public int getTotal_url() {
        return total_url;
    }

    public void setTotal_url(int total_url) {
        this.total_url = total_url;
    }


    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", status=" + status +
                ", cate_name='" + cate_name + '\'' +
                ", des='" + des + '\'' +
                ", icon_name='" + icon_name + '\'' +
                ", total_url=" + total_url +
                '}';
    }
}
