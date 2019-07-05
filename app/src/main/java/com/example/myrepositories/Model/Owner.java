package com.example.myrepositories.Model;

import com.google.gson.annotations.SerializedName;

 public class Owner {
    @SerializedName("id")
    private Integer id;
    @SerializedName("avatar_url")
    private String avatar_url;

    public Owner(Integer id, String avatar_url){
        this.avatar_url =  avatar_url;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
