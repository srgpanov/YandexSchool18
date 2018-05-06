package com.srgpanov.yandexschool18.View;

import android.arch.paging.PagedList;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srgpanov.yandexschool18.ImageAdapter;
import com.srgpanov.yandexschool18.MainThreadExecutor;
import com.srgpanov.yandexschool18.PhotoDataSource;
import com.srgpanov.yandexschool18.R;
import com.srgpanov.yandexschool18.ViewHolderListener;
import com.srgpanov.yandexschool18.data.Photo;

import java.util.ArrayList;
import java.util.concurrent.Executors;


public class FeedFragment extends Fragment {
    private RecyclerView mRecyclerView;

    public FeedFragment() {
    }

    public static FeedFragment newInstance(Bundle args) {
        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.feed_fragment, container, false);
        return mRecyclerView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showFeed();
    }


    public void showFeed() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        PhotoDataSource photoSource = new PhotoDataSource();


        // PagedList
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .setPrefetchDistance(20)
                .build();

        PagedList<Photo> pagedList = new PagedList.Builder<>(photoSource, config)
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .setNotifyExecutor(new MainThreadExecutor())
                .build();

        final ImageAdapter imageAdapter = new ImageAdapter();
        imageAdapter.submitList(pagedList);
        mRecyclerView.setAdapter(imageAdapter);
        imageAdapter.setViewHolderListener(new ViewHolderListener() {
            @Override
            public void onItemClicked(View view, int position) {

                int startPosition = position - 20;
                if (startPosition < 0) {
                    startPosition = 0;
                }
                ArrayList<Photo> photos = new ArrayList<>(imageAdapter.getCurrentList().subList(startPosition, position + 15));
                Intent intent = new Intent(getActivity(), Detail_Image_Activity.class);
                intent.putParcelableArrayListExtra("photos", photos);
                intent.putExtra("position", photos);
                getActivity().startActivity(intent);

            }
        });

    }


}




