package com.srgpanov.yandexschool18.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.srgpanov.yandexschool18.R;

public class OfflineFragment extends Fragment {
    public static OfflineFragment newInstance(Bundle args) {
        OfflineFragment fragment = new OfflineFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        return inflater.inflate(R.layout.offline_fragment, container, false);
    }
}
