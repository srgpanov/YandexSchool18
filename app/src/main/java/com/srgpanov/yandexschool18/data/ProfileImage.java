package com.srgpanov.yandexschool18.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileImage {
    @SerializedName("small")
    @Expose
    public String small;
    @SerializedName("medium")
    @Expose
    public String medium;
    @SerializedName("large")
    @Expose
    public String large;
}
