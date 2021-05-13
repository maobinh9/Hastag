package com.example.hastag.Model;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class Hashtag implements Serializable {

    @SerializedName("detailList")
    @Expose
    private List<String> detailList = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("urlImage")
    @Expose
    private String urlImage;

    public List<String> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<String> detailList) {
        this.detailList = detailList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

}
