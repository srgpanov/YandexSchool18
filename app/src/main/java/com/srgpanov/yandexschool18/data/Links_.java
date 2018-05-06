package com.srgpanov.yandexschool18.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ implements Parcelable {
    @SerializedName("self")
    @Expose
    public String self;
    @SerializedName("html")
    @Expose
    public String html;
    @SerializedName("download")
    @Expose
    public String download;
    @SerializedName("download_location")
    @Expose
    public String downloadLocation;

    public static final Parcelable.Creator<Links_> CREATOR = new Parcelable.Creator<Links_>() {
        @Override
        public Links_ createFromParcel(Parcel source) {
            return new Links_(source);
        }

        @Override
        public Links_[] newArray(int size) {
            return new Links_[size];
        }
    };

    public Links_() {
    }

    protected Links_(Parcel in) {
        this.self = in.readString();
        this.html = in.readString();
        this.download = in.readString();
        this.downloadLocation = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.self);
        dest.writeString(this.html);
        dest.writeString(this.download);
        dest.writeString(this.downloadLocation);
    }
}
