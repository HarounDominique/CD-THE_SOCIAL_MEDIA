package com.campusdual.PostTypeClasses;

import com.campusdual.PostSupportClasses.ImageDimensions;

public class ImageContentPost{
    private String title;
    private ImageDimensions dimensions;

    public ImageContentPost(String title, ImageDimensions dimensions) {
        this.title = title;
        this.dimensions = dimensions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageDimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(ImageDimensions dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "ImageContentPost{" +
                "title='" + title + '\'' +
                ", dimensions=" + dimensions +
                '}';
    }
}
