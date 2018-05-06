package com.srgpanov.yandexschool18.View;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.srgpanov.yandexschool18.R;
import com.srgpanov.yandexschool18.SlidingImageAdapter;
import com.srgpanov.yandexschool18.data.Photo;

import java.util.ArrayList;
import java.util.List;

public class Detail_Image_Activity extends AppCompatActivity {

    private ViewPager mPager;
    private SlidingImageAdapter mImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail__image_);

        ArrayList<Photo> photos = getIntent().getParcelableArrayListExtra("photos");
        mPager = (ViewPager) findViewById(R.id.detail_image_view_pager);
        mPager.setAdapter(mImageAdapter);
        mImageAdapter = new SlidingImageAdapter();
        mPager.setAdapter(mImageAdapter);
        addViews(photos);
    }

    private void addViews(List<Photo> photos) {
        LayoutInflater inflater = getLayoutInflater();
        for (Photo photo : photos) {
            PhotoView imageView = (PhotoView) inflater.inflate(R.layout.sliding_image, null);
            Glide.with(this)
                    .load(photo.urls.raw)
                    .thumbnail(Glide.with(this)
                            .load(photo.urls.thumb))
                    .into(imageView);
            mImageAdapter.addView(imageView);
        }

        mPager.setCurrentItem(photos.size() - 15);
        mImageAdapter.notifyDataSetChanged();
    }


}
