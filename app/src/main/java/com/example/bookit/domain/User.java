package com.example.bookit.domain;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String profileImage;
    private String name;
    private String loginId;
    private String password;

    public User(int id, String profileImage, String name, String loginId, String password) {
        this.id = id;
        this.profileImage = profileImage;
        this.name = name;
        this.loginId = loginId;
        this.password = password;
    }

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", profileImage='" + profileImage + '\'' +
                ", name='" + name + '\'' +
                ", loginId='" + loginId + '\'' +
                ", passward='" + password + '\'' +
                '}';
    }
}
