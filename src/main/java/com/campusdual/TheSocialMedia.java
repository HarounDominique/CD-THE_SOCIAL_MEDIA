package com.campusdual;

import java.util.*;
import com.campusdual.util.Input;

public class TheSocialMedia {
    /**----------ATTRIBUTES----------**/
    ArrayList<User> userList = null;
    ArrayList<Post> postList = null;
    ArrayList<Comment> commentList = null;
    ArrayList<String> mailList = null;
    ArrayList<String> nameList = null;
    ArrayList<String> passList = null;

    /**----------METHODS----------**/

    /**CONSTRUCTOR**/
    public TheSocialMedia(ArrayList<User> userList, ArrayList<Post> postList, ArrayList<Comment> commentList, ArrayList<String> mailList, ArrayList<String> nameList, ArrayList<String> passList) {
        this.userList = userList;
        this.postList = postList;
        this.commentList = commentList;
        this.mailList = mailList;
        this.nameList = nameList;
        this.passList = passList;
    }

    public TheSocialMedia() {
    }

    /**GETTERS AND SETTERS**/
    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Post> getPostList() {
        return postList;
    }

    public void setPostList(ArrayList<Post> postList) {
        this.postList = postList;
    }

    public ArrayList<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "TheSocialMedia{" +
                "userList=" + userList +
                ", postList=" + postList +
                ", commentList=" + commentList +
                '}';
    }

    /**CUSTOM METHODS**/
    public boolean addUser(){
        String userMail;
        String userName;
        String userPass;

        boolean validMail = false;
        boolean uniqueMail = false;
        do {
            System.out.println("*********************     LOGIN      *********************");
            System.out.println("*                                                        *");
            System.out.println("*                   Insert your EMAIL                    *");
            System.out.println("*                                                        *");
            System.out.print("* >>> ");
            userMail = Input.string();
            if (userMail.trim().isEmpty()){
                System.out.println("INVALID EMAIL");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("\033[1A"); // Mueve el cursor una línea hacia arriba
                System.out.print("\033[2K"); // Borra la línea actual
            }else{
                validMail = true;
            }
        }while(!validMail);


            Iterator<String> iterator = this.mailList.iterator();
            while (iterator.hasNext()) {
                String dummyMail = iterator.next();
                if (dummyMail.equals(userMail)) {
                    System.out.println("USER MAIL ALREADY IN USE");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print("\033[1A"); // Mueve el cursor una línea hacia arriba
                    System.out.print("\033[2K"); // Borra la línea actual
                    ui();
                } else {
                    uniqueMail = true;
                }
            }
                boolean validName = false;
                do {
                    System.out.println("*********************     LOGIN      *********************");
                    System.out.println("*                                                        *");
                    System.out.println("*                 Insert your USER NAME                  *");
                    System.out.println("*                                                        *");
                    System.out.print("* >>> ");
                    userName = Input.string();
                    if (userName.trim().isEmpty()) {
                        System.out.println("INVALID NAME");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print("\033[1A"); // Mueve el cursor una línea hacia arriba
                        System.out.print("\033[2K"); // Borra la línea actual
                    } else {
                        validName = true;
                    }
                } while (!validName);
                //INSERT PASSWORD


        return validPass;
    }

    public boolean removeUser(User u){
        boolean userRemoved = false;
        Iterator<User> iterator = this.userList.iterator();
        while (iterator.hasNext()) {
            User dummyUser = iterator.next();
            if (dummyUser.equals(u)) {
                iterator.remove();
                userRemoved = true;
            }
        }
        return userRemoved;
    }

    public boolean removePost(Post p){
        boolean postRemoved = false;
        Iterator<Post> iterator = this.postList.iterator();
        while (iterator.hasNext()) {
            Post dummyPost = iterator.next();
            if (dummyPost.equals(p)) {
                iterator.remove();
                postRemoved = true;
            }
        }
        return postRemoved;
    }

    public boolean removeComment(Comment c){
        boolean commentRemoved = false;
        Iterator<Comment> iterator = this.commentList.iterator();
        while (iterator.hasNext()) {
            Comment dummyComment = iterator.next();
            if (dummyComment.equals(c)) {
                iterator.remove();
                commentRemoved = true;
            }
        }
        return commentRemoved;
    }

    public void ui(){
        boolean on = true;
        do{
            System.out.println("*********************THE SOCIAL MEDIA*********************");
            System.out.println("*                                                        *");
            System.out.println("*                   Insert '0' to EXIT                   *");
            System.out.println("*                                                        *");
            System.out.println("*                   Insert '1' to LOGIN                  *");
            System.out.println("*                                                        *");
            System.out.println("*                  Insert '2' to SIGN IN                 *");
            System.out.print("* >>> ");
            String answer = Input.string();
            if(answer.trim().equals("0")){
                System.out.println("BYE");
                on = false;
            }
        }while(on);
    }
}



