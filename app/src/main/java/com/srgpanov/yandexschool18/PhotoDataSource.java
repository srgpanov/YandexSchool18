package com.srgpanov.yandexschool18;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import com.srgpanov.yandexschool18.data.Photo;
import com.srgpanov.yandexschool18.network.RetrofitClient;
import com.srgpanov.yandexschool18.network.Unsplash_API;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDataSource extends PageKeyedDataSource<String,Photo> {

    private Unsplash_API unsplash_api;



    @Override
    public void loadInitial(@NonNull LoadInitialParams<String> params, @NonNull final LoadInitialCallback<String, Photo> callback) {

        unsplash_api= RetrofitClient.getUsplashApi();
        Call<List<Photo>> photoInitial = unsplash_api.getPhotos(Unsplash_API.CLIENT_ID);
        photoInitial.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                Log.d("next",response.headers().value(6));
                callback.onResult(response.body(), null, response.headers().values("link").get(0));

            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
    }


    @Override
    public void loadBefore(@NonNull LoadParams<String> params, @NonNull final LoadCallback<String, Photo> callback) {
    }


    @Override
    public void loadAfter(@NonNull LoadParams<String> params, @NonNull final LoadCallback<String, Photo> callback) {
        final Page nextPage = getNextKey(params.key);

        Call<List<Photo>> photoNext = unsplash_api.getPhotosNext(nextPage.getClientID(), nextPage.getPage());
        photoNext.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                callback.onResult(response.body(), response.headers().values("link").get(0));
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });

    }


    private Page getNextKey(String key) {

        Log.d("size", String.valueOf(key));
        String[] links = key.split(",");
        String nextLinks = "";
        for (String s : links) {
            if (s.contains("rel=\"next\"")) {
                nextLinks = s;
                Log.d("nextpage", nextLinks);
            }
        }
        String page = nextLinks.substring(nextLinks.indexOf("page=") + 5, nextLinks.indexOf(">"));
        String clientID = nextLinks.substring(nextLinks.indexOf("client_id") + 10, nextLinks.indexOf("&"));
        Page nextPage = new Page(clientID, page);
        Log.d("nextpage", nextPage.toString());
        return nextPage;
    }

    private Page getPreviousKey(String key) {

        Log.d("size", String.valueOf(key));
        String[] links = key.split(",");
        String nextLinks = "";
        for (String s : links) {
            if (s.contains("rel=\"prev\"")) {
                nextLinks = s;
                Log.d("prevpage", nextLinks);
            }
        }
        String page = nextLinks.substring(nextLinks.indexOf("page=") + 5, nextLinks.indexOf(">"));
        String clientID = nextLinks.substring(nextLinks.indexOf("client_id") + 10, nextLinks.indexOf("&"));
        Page nextPage = new Page(clientID, page);
        Log.d("nextpage", nextPage.toString());
        return nextPage;
    }


}
