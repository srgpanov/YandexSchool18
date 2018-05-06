package com.srgpanov.yandexschool18.data;

import android.nfc.Tag;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

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
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("urls")
    @Expose
    public Urls urls;
    @SerializedName("links")
    @Expose
    public Links links;
    @SerializedName("categories")
    @Expose
    public List<Object> categories = null;
    @SerializedName("sponsored")
    @Expose
    public Boolean sponsored;
    @SerializedName("likes")
    @Expose
    public Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    public Boolean likedByUser;
    @SerializedName("current_user_collections")
    @Expose
    public List<Object> currentUserCollections = null;
    @SerializedName("slug")
    @Expose
    public Object slug;
    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("tags")
    @Expose
    public List<Tag> tags = null;
    @SerializedName("photo_tags")
    @Expose
    public List<PhotoTag> photoTags = null;

}