package com.campusdual;

import java.util.*;

public class TheSocialMedia {
    /**USER CLASS**/
    private class User {
        private String name;
        private ArrayList<User> follows;
        private ArrayList<Post> posts;

        public User(String name, ArrayList<User> follows, ArrayList<Post> posts) {
            this.name = name;
            this.follows = follows;
            this.posts = posts;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<User> getFollows() {
            return follows;
        }

        public void setFollows(ArrayList<User> follows) {
            this.follows = follows;
        }

        public ArrayList<Post> getPosts() {
            return posts;
        }

        public void setPosts(ArrayList<Post> posts) {
            this.posts = posts;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", follows=" + follows +
                    ", posts=" + posts +
                    '}';
        }
    }

    /**CLASSES ON WHICH THE POST CLASS DEPENDS**/
    public enum Quality {
        BAJA, MEDIA, ALTA, MUY_ALTA
    }
    private class ImageDimensions{
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

    /**CLASSES THAT DETERMINE THE TYPE OF POST: STRING, IMAGE, VIDEO **/

    private class StringContentPost {
        private String content;

        public StringContentPost(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "stringContentPost{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }

    private class ImageContentPost{
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
    private class VideoContentPost{
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

    /**COMMENT CLASS**/
    private class Comment{
        private String commentBody;
        private Date commentDate;
        private User commentUser;

        public Comment(String commentBody, Date commentDate, User commentUser) {
            this.commentBody = commentBody;
            this.commentDate = commentDate;
            this.commentUser = commentUser;
        }

        public String getCommentBody() {
            return commentBody;
        }

        public void setCommentBody(String commentBody) {
            this.commentBody = commentBody;
        }

        public Date getCommentDate() {
            return commentDate;
        }

        public void setCommentDate(Date commentDate) {
            this.commentDate = commentDate;
        }

        public User getCommentUser() {
            return commentUser;
        }

        public void setCommentUser(User commentUser) {
            this.commentUser = commentUser;
        }

        @Override
        public String toString() {
            return "Comment{" +
                    "commentBody='" + commentBody + '\'' +
                    ", commentDate=" + commentDate +
                    ", commentUser=" + commentUser +
                    '}';
        }
    }

    /**POST CLASS**/
    private class Post{
        private Date date;
        private ArrayList<Comment> comments;
        private StringContentPost stringContentPost;
        private ImageContentPost imageContentPost;
        private VideoContentPost videoContentPost;
    }

    /**----------------------------------------METHODS----------------------------------------**/



}

