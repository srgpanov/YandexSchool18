package com.srgpanov.yandexschool18;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.srgpanov.yandexschool18.data.Photo;

import java.util.List;

public class ImageEasyAdapter extends RecyclerView.Adapter<ImageEasyAdapter.PhotoViewHolder> {
    private List<Photo> mPhotoList;
    private CustomClickListener mClickListener;
    private Context mContext;

    public ImageEasyAdapter(List<Photo> photoList, CustomClickListener clickListener) {
        mPhotoList = photoList;
        mClickListener = clickListener;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,parent,false);
        mContext = parent.getContext();
        return new PhotoViewHolder(view,mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Log.d("picasso",mPhotoList.get(position).urls.regular);


    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImageView;
        private CustomClickListener mListener;
        public PhotoViewHolder(View itemView, CustomClickListener customClickListener) {
            super(itemView);
            this.mListener=customClickListener;
            mImageView=(ImageView)itemView.findViewById(R.id.item_img);
            mImageView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClickListener(view, getAdapterPosition());
            }
        }
    }
}
