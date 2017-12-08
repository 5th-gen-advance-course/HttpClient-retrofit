package com.example.ratha.httpclientdemo.repository;

import com.example.ratha.httpclientdemo.entity.BaseEntity;
import com.example.ratha.httpclientdemo.entity.CategoryByIdResponse;
import com.example.ratha.httpclientdemo.entity.CategoryCreateResponseObservable;
import com.example.ratha.httpclientdemo.entity.CategoryPost;
import com.example.ratha.httpclientdemo.entity.CategoryPostResponse;
import com.example.ratha.httpclientdemo.entity.CategoryResponse;
import com.example.ratha.httpclientdemo.entity.CategoryUpdate;
import com.example.ratha.httpclientdemo.entity.DeleteResponse;


import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by ratha on 11/28/2017.
 */

public interface Knongdai {

    interface CategoryService{
        @GET("/api/v1/categories")
        Call<CategoryResponse> getCategories();

        @GET("/api/v1/categories")
        Observable<Response<CategoryResponse>> getCategoriesObservable();

        @GET("/api/v1/categories/{id}")
        Call<CategoryByIdResponse> getCategory(@Path("id") int id);

        @POST("/api/v1/categories/create-main")
        Call<CategoryPostResponse> createCategory(@Body CategoryPost category);

        @POST("/api/v1/categories/create-main")
        Observable<Response<CategoryCreateResponseObservable>> createCategoryObservable(@Body CategoryPost category);

        @PUT("/api/v1/categories/update-main")
        Call<CategoryUpdate> updateCategory(@Body CategoryPost category);

        @PUT("/api/v1/categories/update-main")
        Observable<Response<CategoryUpdate>> editCategoryObservable(@Body CategoryPost category);

        @DELETE("/api/v1/categories/{id}/delete")
        Call<DeleteResponse> deleteCategory(@Path("id") int id);

        @DELETE("/api/v1/categories/{id}/delete")
        Single<Response<DeleteResponse>> removeCategory(@Path("id") int id);


    }
}
