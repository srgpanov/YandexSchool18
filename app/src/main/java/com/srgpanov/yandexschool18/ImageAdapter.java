package com.srgpanov.yandexschool18;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.srgpanov.yandexschool18.data.Photo;

public class ImageAdapter extends PagedListAdapter<Photo,ImageAdapter.PhotoViewHolder>   {
    private ViewHolderListener mHolderListener;
    private Context mContext;


    public ImageAdapter() {
        super(DIFF_CALLBACK);


    }

    public void setViewHolderListener(ViewHolderListener listener) {
        mHolderListener = listener;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,parent,false);
        mContext = parent.getContext();
        return new PhotoViewHolder(view, mHolderListener);
    }

    @Nullable
    @Override
    public Photo getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo photo = getItem(position);
        Glide.with(mContext)
                .load(getItem(position).urls.thumb)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .apply(RequestOptions.overrideOf(ScreenResolution.getWidthDisplay(mContext)/2))
                .apply(RequestOptions.centerCropTransform())
                .into(holder.mImageView);
        ViewCompat.setTransitionName(holder.mImageView, photo.id);


    }
    public static final DiffUtil.ItemCallback<Photo> DIFF_CALLBACK =new DiffUtil.ItemCallback<Photo>() {
        @Override
        public boolean areItemsTheSame(Photo oldItem, Photo newItem) {
            return oldItem.id.equals(newItem.id);
        }

        @Override
        public boolean areContentsTheSame(Photo oldItem, Photo newItem) {
            return oldItem.id.equals(newItem.id);
        }
    };


    public class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mImageView;
        private ViewHolderListener mListener;

        public PhotoViewHolder(View itemView, ViewHolderListener customClickListener) {
            super(itemView);
            this.mListener=customClickListener;
            mImageView=(ImageView)itemView.findViewById(R.id.item_img);
            mImageView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClicked(view, getAdapterPosition());
            }
        }
    }

}
