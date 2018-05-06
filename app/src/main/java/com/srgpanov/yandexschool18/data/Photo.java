package com.srgpanov.yandexschool18.data;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Photo implements Parcelable {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("width")
    @Expose
    public Integer width;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("likes")
    @Expose
    public Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    public Boolean likedByUser;
    @SerializedName("description")
    @Expose
    public Object description;
    @SerializedName("sponsored")
    @Expose
    public Boolean sponsored;
    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("current_user_collections")
    @Expose
    public List<Object> currentUserCollections = null;
    @SerializedName("urls")
    @Expose
    public Urls urls;
    @SerializedName("categories")
    @Expose
    public List<Object> categories = null;
    @SerializedName("links")
    @Expose
    public Links_ links;

    public static final Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel source) {
            return new Photo(source);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public Photo() {
    }

    protected Photo(Parcel in) {
        this.id = in.readString();
        this.createdAt = in.readString();
        this.updatedAt = in.readString();
        this.width = (Integer) in.readValue(Integer.class.getClassLoader());
        this.height = (Integer) in.readValue(Integer.class.getClassLoader());
        this.color = in.readString();
        this.likes = (Integer) in.readValue(Integer.class.getClassLoader());
        this.likedByUser = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.description = in.readParcelable(Object.class.getClassLoader());
        this.sponsored = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.user = in.readParcelable(User.class.getClassLoader());
        this.currentUserCollections = new ArrayList<Object>();
        in.readList(this.currentUserCollections, Object.class.getClassLoader());
        this.urls = in.readParcelable(Urls.class.getClassLoader());
        this.categories = new ArrayList<Object>();
        in.readList(this.categories, Object.class.getClassLoader());
        this.links = in.readParcelable(Links_.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
        dest.writeValue(this.width);
        dest.writeValue(this.height);
        dest.writeString(this.color);
        dest.writeValue(this.likes);
        dest.writeValue(this.likedByUser);
        dest.writeParcelable((Parcelable) this.description, flags);
        dest.writeValue(this.sponsored);
        dest.writeParcelable(this.user, flags);
        dest.writeList(this.currentUserCollections);
        dest.writeParcelable(this.urls, flags);
        dest.writeList(this.categories);
        dest.writeParcelable(this.links, flags);
    }
}