package com.example.mangabook.Models;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Manga implements Serializable {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

}