package com.campusdual;

import java.util.ArrayList;
import java.util.Iterator;

public class User {
    /**FIELDS**/
    private String name;
    private ArrayList<User> followedUsers;
    private ArrayList<Post> posts;
    private ArrayList<Comment> comments;

    /**METHODS**/

    public User(String name, ArrayList<User> follows, ArrayList<Post> posts) {
        this.name = name;
        this.followedUsers = follows;
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getFollowedUsers() {
        return followedUsers;
    }

    public void setFollowedUsers(ArrayList<User> followedUsers) {
        this.followedUsers = followedUsers;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", follows=" + followedUsers +
                ", posts=" + posts +
                '}';
    }

    /**CUSTOM METHODS**/
    public boolean follow(User u){
        boolean followed = false;
        for(User user : followedUsers){
            if(user.equals(u)){
                followed = false;
                break;
            }else{
                this.followedUsers.add(u);
                followed = true;
            }
        }
        return followed;
    }

        /*
        public boolean unfollow(User u){
            boolean removed = false;
            for(User user : followedUsers){
                if(user.equals(u)){
                    followedUsers.remove(user);
                    removed = true;
                    break;
                }
            }
            return removed;
        }
        */

    public boolean unfollow(User u) {
        Iterator<User> iterator = followedUsers.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.equals(u)) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    public ArrayList<Post> showAllPost(){
        return getPosts();
    }

    public ArrayList<Comment> showAllComments(){
        return getComments();
    }

    public void showUserWall(){
        int counter = 0;
        TheSocialMedia tsm = new TheSocialMedia();
        Iterator<Post> iterator = tsm.getPostList().iterator();
        while(counter<10 && iterator.hasNext() ){
            for(Post p : tsm.getPostList()){
                for(User u : this.followedUsers){
                    if (p.getCreator().equals(u)){
                        System.out.println("Author: "+p.getCreator()+"\nContent: "+ p);
                        counter++;
                    }
                }
            }
        }
    }
}
