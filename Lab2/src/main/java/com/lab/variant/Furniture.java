package com.lab.variant;

public class Furniture {
    private String id;
    private String title;
    private String imgUrl;
    private String description;
    private String size;

    public Furniture() {}

    public Furniture(String id, String title, String imgUrl, String description, String size) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
        this.description = description;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
    }
    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }
}

