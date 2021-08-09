package com.systrack.admission.Retrofit;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {


    private static Retrofit retrofit = null;
public static String Base_url="http://192.168.1.35/Admission/services/";
    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(2, TimeUnit.HOURS)
                .readTimeout(2, TimeUnit.HOURS)
                .writeTimeout(2, TimeUnit.HOURS)
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                //.baseUrl("http://182.18.161.104/dental/services/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;

    }
}
