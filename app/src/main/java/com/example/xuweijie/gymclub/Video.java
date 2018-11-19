package com.example.xuweijie.gymclub;

public class Video {
    private int url;
    private String title;
    private String introduction;
    private String hit;

    public Video(int url, String title, String introduction, String hit){
        this.url=url;
        this.title=title;
        this.introduction=introduction;
        this.hit=hit;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
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

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }
}
