package com.srgpanov.yandexschool18;

import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;
import android.util.Log;

import com.srgpanov.yandexschool18.data.Photo;
import com.srgpanov.yandexschool18.network.RetrofitClient;
import com.srgpanov.yandexschool18.network.Unsplash_API;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDataSource extends PageKeyedDataSource<String,Photo> {

    private Unsplash_API unsplash_api;




    @Override
    public void loadInitial(@NonNull LoadInitialParams<String> params, @NonNull final LoadInitialCallback<String, Photo> callback) {
        final List<Photo> photoList = new ArrayList<>();
        unsplash_api= RetrofitClient.getUsplashApi();
        Call<List<Photo>> photoInitial = unsplash_api.getPhotos(Unsplash_API.CLIENT_ID);
        photoInitial.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                photoList.addAll(response.body());
                Log.d("next",response.headers().value(6));
                callback.onResult(photoList,null,response.headers().value(6));
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<String> params, @NonNull final LoadCallback<String, Photo> callback) {
        Log.d("LoadBefore",params.key.toString());
        String nextPage = params.key;
        int prevIndex =nextPage.indexOf("rel=\"prev\"");
        int endBracket = 0;
        int startBracket = 0;
        for (int i=prevIndex;i==0;i--){
            if (nextPage.charAt(i)=='>') endBracket=i;
            if (nextPage.charAt(i)=='<') startBracket=i;
            break;
        }

        String nextPhotos = nextPage.substring(startBracket,endBracket);
        String clientId = nextPhotos.substring(nextPhotos.indexOf("client_id")+10,nextPhotos.indexOf("page=")-1);
        String page = nextPhotos.substring(nextPhotos.indexOf("page=")+5);
        Log.d("prevPhotos",clientId);
        Log.d("page",page);
        Call<List<Photo>>photoPrev =unsplash_api.getPhotosNext(clientId,page);
        photoPrev.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                callback.onResult(response.body(),response.headers().toString());
                Log.d("request",String.valueOf(call.request().toString()));
                Log.d("request",String.valueOf(response.headers()));

            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });

    }



    @Override
    public void loadAfter(@NonNull LoadParams<String> params, @NonNull final LoadCallback<String, Photo> callback) {
        String nextPage = params.key;
        int nextIndex =nextPage.indexOf("rel=\"next\"");
        int lastIndex = nextPage.indexOf("rel=\"last\"");
        int clientIndex = nextPage.indexOf("client_id",lastIndex)+10;
        int endIndex = nextPage.indexOf(">",lastIndex);
        String nextPhotos = nextPage.substring(clientIndex,endIndex);
        String clientId = nextPhotos.substring(0,nextPhotos.indexOf("page=")-1);
        String page = nextPhotos.substring(nextPhotos.indexOf("page=")+5);
        Log.d("nextPhotos",clientId);
        Log.d("page",page);
        Call<List<Photo>>photoNext =unsplash_api.getPhotosNext(clientId,page);
        photoNext.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                callback.onResult(response.body(),response.headers().toString());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });

    }
}
