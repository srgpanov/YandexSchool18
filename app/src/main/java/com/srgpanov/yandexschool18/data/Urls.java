package com.srgpanov.yandexschool18.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Urls implements Parcelable {

    @SerializedName("raw")
    @Expose
    public String raw;
    @SerializedName("full")
    @Expose
    public String full;
    @SerializedName("regular")
    @Expose
    public String regular;
    @SerializedName("small")
    @Expose
    public String small;
    @SerializedName("thumb")
    @Expose
    public String thumb;

    public static final Parcelable.Creator<Urls> CREATOR = new Parcelable.Creator<Urls>() {
        @Override
        public Urls createFromParcel(Parcel source) {
            return new Urls(source);
        }

        @Override
        public Urls[] newArray(int size) {
            return new Urls[size];
        }
    };

    public Urls() {
    }

    protected Urls(Parcel in) {
        this.raw = in.readString();
        this.full = in.readString();
        this.regular = in.readString();
        this.small = in.readString();
        this.thumb = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.raw);
        dest.writeString(this.full);
        dest.writeString(this.regular);
        dest.writeString(this.small);
        dest.writeString(this.thumb);
    }
}
