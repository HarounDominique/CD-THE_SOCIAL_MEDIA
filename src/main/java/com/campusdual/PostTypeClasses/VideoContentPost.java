package com.campusdual.PostTypeClasses;

import com.campusdual.PostSupportClasses.Quality;

public class VideoContentPost{
    private String title;
    private Quality quality;
    private int duration;

    public VideoContentPost(String title, Quality quality, int duration) {
        this.title = title;
        this.quality = quality;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "VideoContentPost{" +
                "title='" + title + '\'' +
                ", quality=" + quality +
                ", duration=" + duration +
                '}';
    }
}
