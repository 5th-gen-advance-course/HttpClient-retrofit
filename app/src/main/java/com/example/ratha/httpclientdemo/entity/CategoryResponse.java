package com.example.ratha.httpclientdemo.entity;

import java.util.List;

/**
 * Created by ratha on 11/29/2017.
 */

public class CategoryResponse {

    public String code;
    public boolean status;
    public String msg;
    public List<Category> data;

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

    public List<Category> getData() {
        return data;
    }

    public void setData(List<Category> data) {
        this.data = data;
    }

    public static class SubCategory {
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

    public static class Category {
        public int id;
        public boolean status;
        public String cate_name;
        public String des;
        public String icon_name;
        public List<SubCategory> sub_cate;

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

        public List<SubCategory> getSub_cate() {
            return sub_cate;
        }

        public void setSub_cate(List<SubCategory> sub_cate) {
            this.sub_cate = sub_cate;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", status=" + status +
                    ", cate_name='" + cate_name + '\'' +
                    ", des='" + des + '\'' +
                    ", icon_name='" + icon_name + '\'' +
                    ", sub_cate=" + sub_cate +
                    '}';
        }
    }
}
