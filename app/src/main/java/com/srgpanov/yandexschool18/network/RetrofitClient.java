package com.srgpanov.yandexschool18.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    static String BASE_URL = "https://api.unsplash.com/";
    public static Unsplash_API getUsplashApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(Unsplash_API.class);
    }
}
