package com.campusdual;

import com.campusdual.util.Input;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;

public class User {
    /**FIELDS**/
    private String name;
    private String mail;
    private String pass;
    private ArrayList<User> followedUsers = new ArrayList<>();
    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();

    /**METHODS**/
    public User(String name, String mail, String pass, ArrayList<User> followedUsers, ArrayList<Post> posts, ArrayList<Comment> comments) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
        this.followedUsers = followedUsers;
        this.posts = posts;
        this.comments = comments;
    }

    public User(String name, String mail, String pass) {
        this.name = name;
        this.mail = mail;
        this.pass = pass;
    }

    public User() {

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
    public void addPost(Post p){
        this.posts.add(p);
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
                ", mail='" + mail + '\'' +
                ", pass='" + pass + '\'' +
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

    public void showAllPost(){
        //return getPosts();
        Iterator<Post> iterator = this.posts.iterator();
        int index=0;
        System.out.println("*********************THE SOCIAL MEDIA*********************");
        System.out.println("*********************   POSTS MENU   *********************");
        System.out.println("*********************   ALL  POSTS   *********************");
        System.out.println("* USER: " + this.name + " | STATUS: LOGGED");
        System.out.println("*                                                        *");
        System.out.println("*                  Insert '0' to GO BACK                 *");
        System.out.println("*                                                        *");
        //System.out.print("* >>> ");
        String answer = Input.string();
        while(iterator.hasNext()){
            index++;
            Post p = iterator.next();
            switch (p.getId()){
                case 1:
                    //string post
                    System.out.println("********************* POST  #"+index+" *********************");
                    System.out.println("* > POST DATE: "+p.getDate());
                    System.out.println("* > AUTHOR: "+ p.getCreator().getName());
                    System.out.println("*                                                        *");
                    System.out.println("* > CONTENT:                                             *");
                    System.out.println("* "+p.getStringContentPost()+"\n");

                case 2:
                    //image post
                    System.out.println("********************* POST  #"+index+" *********************");
                    System.out.println("* > POST DATE: "+p.getDate());
                    System.out.println("* > AUTHOR: "+ p.getCreator().getName());
                    System.out.println("*                                                        *");
                    System.out.println("* > TITLE:                                               *");
                    System.out.println("* "+p.getImageContentPost().getTitle());
                    System.out.println("* > IMAGE DIMENSIONS:                                    *");
                    System.out.println("* "+p.getImageContentPost().getDimensions().getWidth()+" x "+p.getImageContentPost().getDimensions().getHeight()+"\n");
                case 3:
                    //video post
                    int timeUnity=0; //seconds
                    double duration = 0;
                    System.out.println("********************* POST  #"+index+" *********************");
                    System.out.println("* > POST DATE: "+p.getDate());
                    System.out.println("* > AUTHOR: "+ p.getCreator().getName());
                    System.out.println("*                                                        *");
                    System.out.println("* > TITLE:                                               *");
                    System.out.println("* "+p.getVideoContentPost().getTitle());
                    System.out.println("* > VIDEO QUALITY:                                    *");
                    System.out.println("* "+p.getVideoContentPost().getQuality().toString());
                    System.out.println("* > VIDEO DURATION (SECONDS):                               *");
                    if(p.getVideoContentPost().getDuration()>=60){
                        timeUnity = 1; //minutes
                        duration = p.getVideoContentPost().getDuration()/60;
                        if(duration>=60){
                            timeUnity = 2; //hours
                            duration = duration/60;
                            if(duration >=24){
                                timeUnity = 3; //days
                                duration = duration/24;
                            }
                        }
                    }
                    switch (timeUnity){
                        case 0:
                            System.out.println("* "+duration+" seconds.\n");
                            break;
                        case 1:
                            System.out.println("* "+duration+" minutes.\n");
                            break;
                        case 3:
                            System.out.println("* "+duration+" hours.\n");
                            break;
                    }
            }
        }
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
