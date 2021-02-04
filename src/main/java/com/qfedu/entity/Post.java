package com.qfedu.entity;

import java.sql.Timestamp;

public class Post {
    private Integer fid;//发帖id
    private String titles;//发帖标题
    private String fcontent;//发帖内容
    private Integer userid;//用户id
    private String photo;//图片
    private Timestamp time;//发帖时间
    private String username;//用户名

    public Post() {
    }

    public Post(Integer fid, String titles, String fcontent, Integer userid, String photo, Timestamp time, String username) {
        this.fid = fid;
        this.titles = titles;
        this.fcontent = fcontent;
        this.userid = userid;
        this.photo = photo;
        this.time = time;
        this.username = username;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Post{" +
                "fid='" + fid + '\'' +
                ", titles='" + titles + '\'' +
                ", fcontent='" + fcontent + '\'' +
                ", userid=" + userid +
                ", photo='" + photo + '\'' +
                ", time=" + time +
                ", username='" + username + '\'' +
                '}';
    }
}
