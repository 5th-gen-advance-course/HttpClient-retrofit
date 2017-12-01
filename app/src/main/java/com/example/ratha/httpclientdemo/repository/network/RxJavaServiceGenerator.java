package com.example.ratha.httpclientdemo.repository.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ratha on 11/28/2017.
 */

public class RxJavaServiceGenerator {

    private static final String BASE_URL="http://110.74.194.125:15000/";
    private static OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
    private static Retrofit.Builder builder=new Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> service){
        Retrofit retrofit=builder
                .client(httpClient.build())
                .build();
        return  retrofit.create(service);
    }

}
