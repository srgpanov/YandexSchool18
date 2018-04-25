package com.srgpanov.yandexschool18.View;

import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srgpanov.yandexschool18.CustomClickListener;
import com.srgpanov.yandexschool18.ImageAdapter;
import com.srgpanov.yandexschool18.MainThreadExecutor;
import com.srgpanov.yandexschool18.PhotoDataSource;
import com.srgpanov.yandexschool18.Presenter.FeedPresenter;
import com.srgpanov.yandexschool18.R;
import com.srgpanov.yandexschool18.data.Photo;

import java.util.concurrent.Executors;

public class FeedFragment extends Fragment implements FeedInterface {
    private RecyclerView mRecyclerView;
    private IFeedPresenter mPresenter;

    public FeedFragment() {
    }

    public static FeedFragment newInstance(Bundle args) {
        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new FeedPresenter();


    }

    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        return inflater.inflate(R.layout.feed_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView  = (RecyclerView)view.findViewById(R.id.feed_recyclerview);
        mPresenter.onViewAttached(this);
    }

    @Override
    public void showFeed() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        PhotoDataSource source = new PhotoDataSource();
        // PagedList
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build();

        PagedList<Photo> pagedList = new PagedList.Builder<>(source, config)
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .setNotifyExecutor(new MainThreadExecutor())
                .build();
        final ImageAdapter imageAdapter;
        imageAdapter= new ImageAdapter();
        imageAdapter.submitList(pagedList);
        mRecyclerView.setAdapter(imageAdapter);
        imageAdapter.setOnClickListener(new CustomClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                mPresenter.onItemClick(position,imageAdapter.getItem(position));
            }
        });
    }
}
