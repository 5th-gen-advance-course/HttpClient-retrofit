package com.example.ratha.httpclientdemo.repository.network;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Asus on 12/8/2017.
 */

public class ServiceGeneratorRxAndroid {

    private static final String BASE_URL="http://110.74.194.125:15000/";
    private static OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
    static RxJava2CallAdapterFactory rxJava2CallAdapterFactory= RxJava2CallAdapterFactory.create();
    static {
        rxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());
    }
    private static Retrofit.Builder builder=new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxJava2CallAdapterFactory);

    public static <S> S createService(Class<S> service){
        Retrofit retrofit=builder
                .client(httpClient.build())
                .build();
        return  retrofit.create(service);
    }
}
