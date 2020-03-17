package com.mitha.ver2mvicall.model;

public class Explore {

    private String name, video_url, image_banner;

    public Explore(String name, String video_url, String image_banner) {
        this.name = name;
        this.video_url = video_url;
        this.image_banner = image_banner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getImage_banner() {
        return image_banner;
    }

    public void setImage_banner(String image_banner) {
        this.image_banner = image_banner;
    }
}
