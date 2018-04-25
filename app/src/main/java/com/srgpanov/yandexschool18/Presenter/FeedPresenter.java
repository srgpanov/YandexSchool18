package com.srgpanov.yandexschool18.Presenter;

import android.content.Context;

import com.srgpanov.yandexschool18.View.FeedInterface;
import com.srgpanov.yandexschool18.View.IFeedPresenter;
import com.srgpanov.yandexschool18.data.Photo;

public class FeedPresenter implements IFeedPresenter {
    private Context mContext;

    public FeedPresenter() {
    }

    @Override
    public void onItemClick(int position, Photo photo) {

    }

    @Override
    public void onViewAttached(FeedInterface view) {
        view.showFeed();

    }

    @Override
    public void onViewDetached() {

    }

    @Override
    public void onViewDestroyed() {

    }

    @Override
    public void onDestroyed() {

    }
}
