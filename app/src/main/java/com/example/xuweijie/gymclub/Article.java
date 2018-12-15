package com.example.xuweijie.gymclub;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "article")
public class Article {
    @PrimaryKey
    private int aid;

//    @ColumnInfo(name="title")
    private String title;

//    @ColumnInfo(name="introduction")
    private String introduction;

//    @ColumnInfo(name="url")
    private String url;

//    @ColumnInfo(name="hit")
    private int hit;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }
}
