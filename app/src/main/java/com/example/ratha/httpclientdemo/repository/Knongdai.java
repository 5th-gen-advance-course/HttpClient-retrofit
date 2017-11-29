package com.example.ratha.httpclientdemo.repository;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ratha on 11/28/2017.
 */

public interface Knongdai {

    interface CategoryService{
        @GET("api/v1/categories/")
        Call<JSONObject> getCategories();
    }
}
