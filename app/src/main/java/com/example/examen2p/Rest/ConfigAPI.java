package com.example.examen2p.Rest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigAPI {

    public static  String BASE_URL ="https://cataas.com/api/";
    private static Retrofit retrofit = null;

    public static Retrofit client(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

retrofit = new Retrofit.Builder().baseUrl("https://cataas.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build();

return retrofit;
    }
}
