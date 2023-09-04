package com.campusdual;

import com.campusdual.PostTypeClasses.ImageContentPost;
import com.campusdual.PostTypeClasses.StringContentPost;
import com.campusdual.PostTypeClasses.VideoContentPost;

import java.util.ArrayList;
import java.util.Date;

public class Post {

    /**
     * FIELDS
     **/
    private Date date;
    private ArrayList<Comment> comments;
    private StringContentPost stringContentPost;
    private ImageContentPost imageContentPost;
    private VideoContentPost videoContentPost;
    private User creator;

    /**
     * CONSTRUCTORS
     **/
    public Post(Date date, StringContentPost stringContentPost, User creator) {
        this.date = date;
        this.stringContentPost = stringContentPost;
        this.creator = creator;
    }

    public Post(Date date, ImageContentPost imageContentPost, User creator) {
        this.date = date;
        this.imageContentPost = imageContentPost;
        this.creator = creator;
    }

    public Post(Date date, VideoContentPost videoContentPost, User creator) {
        this.date = date;
        this.videoContentPost = videoContentPost;
        this.creator = creator;
    }

    /**
     * METHODS
     **/
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public StringContentPost getStringContentPost() {
        return stringContentPost;
    }

    public void setStringContentPost(StringContentPost stringContentPost) {
        this.stringContentPost = stringContentPost;
    }

    public ImageContentPost getImageContentPost() {
        return imageContentPost;
    }

    public void setImageContentPost(ImageContentPost imageContentPost) {
        this.imageContentPost = imageContentPost;
    }

    public VideoContentPost getVideoContentPost() {
        return videoContentPost;
    }

    public void setVideoContentPost(VideoContentPost videoContentPost) {
        this.videoContentPost = videoContentPost;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * CUSTOM METHODS
     **/
    public void addComment(Comment c) {
        this.comments.add(c);
    }

}
