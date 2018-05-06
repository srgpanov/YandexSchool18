package com.srgpanov.yandexschool18.network;

import com.srgpanov.yandexschool18.data.Photo;
import com.srgpanov.yandexschool18.data.Search;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Unsplash_API {
    String CLIENT_ID = "bb64987f27179560048584c899a677c46036e071b4cac2b726d411eb108b210a";
    @GET("photos")
    Call<List<Photo>> getPhotos(@Query("client_id")String client_id);

    @GET("photos")
    Call<List<Photo>> getPhotosNext(@Query("client_id") String client_id,@Query("page") String page);

    @GET("photos")
    Call<List<Photo>> getPhotosNextPerPage(@Query("client_id") String client_id, @Query("page") String page, @Query("per_page") String per_page);

    @GET("search/photos")
    Call<Search> searchPhoto(@Query("client_id") String client_id, @Query("query") String query);

    @GET("search/photos")
    Call<Search> searchPhotoNext(@Query("client_id") String client_id, @Query("page") String page, @Query("query") String query);
}

