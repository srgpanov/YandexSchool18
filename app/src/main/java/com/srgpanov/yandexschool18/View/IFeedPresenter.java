package com.srgpanov.yandexschool18.View;

import com.srgpanov.yandexschool18.data.Photo;

public interface IFeedPresenter extends BasePresenter<FeedInterface> {
    void onItemClick(int position, Photo photo);
}
