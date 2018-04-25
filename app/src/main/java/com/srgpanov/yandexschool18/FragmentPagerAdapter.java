package com.srgpanov.yandexschool18;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.srgpanov.yandexschool18.View.FeedFragment;
import com.srgpanov.yandexschool18.View.FilesFragment;
import com.srgpanov.yandexschool18.View.OfflineFragment;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[]{"Tab1", "Tab2", "Tab3"};
    private Context context;

    public FragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FeedFragment.newInstance(new Bundle());
            case 1:
                return FilesFragment.newInstance(new Bundle());
            case 2:
                return com.srgpanov.yandexschool18.View.AllPhotosFragment.newInstance(new Bundle());
            case 3:
                return OfflineFragment.newInstance(new Bundle());
            default:
                return FeedFragment.newInstance(new Bundle());
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // генерируем заголовок в зависимости от позиции
        switch (position) {
            case 0:
                return "Лента";
            case 1:
                return "Файлы";
            case 2:
                return "Все фото";
            case 3:
                return "Офлайн";
                default:return "Лента";
    }
}}
