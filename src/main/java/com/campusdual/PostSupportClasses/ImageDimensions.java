package com.campusdual.PostSupportClasses;

public class ImageDimensions{
    private int height;
    private int width;

    public ImageDimensions(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String dimensions(){
        return String.valueOf(this.width)+"X"+String.valueOf(this.height);
    }
}
