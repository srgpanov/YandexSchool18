package com.srgpanov.yandexschool18.data;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

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

}