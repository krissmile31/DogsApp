package com.anhntn45.dogsapp.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogsApiService {
    private static final String URL = "https://raw.githubusercontent.com";

    private DogsApi dogsApi;

    public DogsApiService() {
        dogsApi = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())  // convert json
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  // single -> observable
                .build()
                .create(DogsApi.class);
    }

    public Single<List<Dog>> getDogsApi() {
        return dogsApi.getDogs();
    }
}
