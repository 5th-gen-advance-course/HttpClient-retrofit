package com.example.ratha.httpclientdemo.repository.api;

import com.example.ratha.httpclientdemo.entity.CategoryCreate;
import com.example.ratha.httpclientdemo.entity.CategoryPostResponse;
import com.example.ratha.httpclientdemo.entity.CategoryResponse;
import com.example.ratha.httpclientdemo.entity.DeleteResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Asus on 12/8/2017.
 */

public interface CategoryService {

    @GET("/api/v1/categories")
    Observable<Response<CategoryResponse>> getCategories();

    @POST("/api/v1/categories/create-main")
    Observable<ResponseBody> addCategory(@Body CategoryCreate category);

    @DELETE("/api/v1/categories/{id}/delete")
    Single<Response<DeleteResponse>> removeCategory(@Path("id") int id);

}
