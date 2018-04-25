package com.srgpanov.yandexschool18.View;

public interface BasePresenter<V> {
    void onViewAttached(V view);
    void onViewDetached();
    void onViewDestroyed();
    void onDestroyed();
}
