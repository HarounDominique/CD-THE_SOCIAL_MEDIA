package com.campusdual;

import java.util.ArrayList;
import java.util.Iterator;

/**USER CLASS**/
public class User {
    //FIELDS
    private String name;
    private ArrayList<User> followedUsers;
    private ArrayList<Post> posts;

    //METHODS

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", follows=" + followedUsers +
                ", posts=" + posts +
                '}';
    }

    //CUSTOM METHODS
    public void follow(User u){
        this.followedUsers.add(u);
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
}
