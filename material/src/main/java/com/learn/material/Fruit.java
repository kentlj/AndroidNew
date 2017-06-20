package com.learn.material;

/**
 * Created by yui on 2017/3/6.
 */

public class Fruit {
    private String name;
    private int imageId;

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public Fruit(String name, int imageId) {

        this.name = name;
        this.imageId = imageId;
    }
}
