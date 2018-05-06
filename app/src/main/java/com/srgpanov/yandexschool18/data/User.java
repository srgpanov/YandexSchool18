package com.srgpanov.yandexschool18.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("twitter_username")
    @Expose
    public String twitterUsername;
    @SerializedName("instagram_username")
    @Expose
    public String instagramUsername;
    @SerializedName("portfolio_url")
    @Expose
    public String portfolioUrl;
    @SerializedName("bio")
    @Expose
    public String bio;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("total_likes")
    @Expose
    public Integer totalLikes;
    @SerializedName("total_photos")
    @Expose
    public Integer totalPhotos;
    @SerializedName("total_collections")
    @Expose
    public Integer totalCollections;
    @SerializedName("profile_image")
    @Expose
    public ProfileImage profileImage;
    @SerializedName("links")
    @Expose
    public Links links;

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User() {
    }

    protected User(Parcel in) {
        this.id = in.readString();
        this.updatedAt = in.readString();
        this.username = in.readString();
        this.name = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.twitterUsername = in.readString();
        this.instagramUsername = in.readString();
        this.portfolioUrl = in.readString();
        this.bio = in.readString();
        this.location = in.readString();
        this.totalLikes = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalPhotos = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalCollections = (Integer) in.readValue(Integer.class.getClassLoader());
        this.profileImage = in.readParcelable(ProfileImage.class.getClassLoader());
        this.links = in.readParcelable(Links.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.updatedAt);
        dest.writeString(this.username);
        dest.writeString(this.name);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.twitterUsername);
        dest.writeString(this.instagramUsername);
        dest.writeString(this.portfolioUrl);
        dest.writeString(this.bio);
        dest.writeString(this.location);
        dest.writeValue(this.totalLikes);
        dest.writeValue(this.totalPhotos);
        dest.writeValue(this.totalCollections);
        dest.writeParcelable(this.profileImage, flags);
        dest.writeParcelable(this.links, flags);
    }
}
