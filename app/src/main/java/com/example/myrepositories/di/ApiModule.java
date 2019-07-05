package com.example.myrepositories.di;

import com.example.myrepositories.ViewModel.ApiInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiModule {
    public static final String BASE_URL = "https://api.github.com/orgs/square/";


    public ApiInterface getClient(){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(ApiInterface.class);

     }




}
