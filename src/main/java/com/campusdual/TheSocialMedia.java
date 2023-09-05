package com.campusdual;

import java.util.*;

import com.campusdual.util.Input;

public class TheSocialMedia {
    /**
     * ----------ATTRIBUTES----------
     **/
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<Post> postList = new ArrayList<>();
    ArrayList<Comment> commentList = new ArrayList<>();
    ArrayList<String> mailList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> passList = new ArrayList<>();

    /**----------METHODS----------**/

    /**
     * CONSTRUCTOR
     **/
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

    /**
     * GETTERS AND SETTERS
     **/
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

    /**
     * CUSTOM METHODS
     **/
    public boolean login() {
        String userMail;
        String userName;
        String userPass;

        boolean validMail = false;
        boolean validName = false;
        boolean validPass = false;

        boolean control = false;

        do {
            System.out.println("*********************     LOGIN      *********************");
            System.out.println("*                                                        *");
            System.out.println("*                   Insert your EMAIL                    *");
            System.out.println("*                                                        *");
            System.out.print("* >>> ");
            userMail = Input.string();
            if (userMail.trim().isEmpty()) {
                System.out.println("INVALID EMAIL: NO EMPTY FIELDS");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                validMail = true;
            }
        } while (!validMail);

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
                control = true;
                ui();
            }
        }
        if(control){
            System.exit(0);
        }
        do {
            System.out.println("*********************     LOGIN      *********************");
            System.out.println("*                                                        *");
            System.out.println("*                 Insert your USER NAME                  *");
            System.out.println("*                                                        *");
            System.out.print("* >>> ");
            userName = Input.string();
            if (userName.trim().isEmpty()) {
                System.out.println("INVALID NAME: NO EMPTY FIELDS");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                validName = true;
            }
        } while (!validName);

        do{
            System.out.println("*********************     LOGIN      *********************");
            System.out.println("*                                                        *");
            System.out.println("*               Insert your USER PASSWORD                *");
            System.out.println("*                                                        *");
            System.out.print("* >>> ");
            userPass = Input.string();
            if(!userPass.trim().isEmpty()){
                String userPass2;
                System.out.println("*********************     LOGIN      *********************");
                System.out.println("*                                                        *");
                System.out.println("*               Repeat your USER PASSWORD                *");
                System.out.println("*                                                        *");
                System.out.print("* >>> ");
                userPass2 = Input.string();
                if(userPass2.equals(userPass)){
                    validPass = true;
                    //break;
                }else{
                    System.out.println("INVALID PASSWORD: NO MATCHING PASSWORDS");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    //DO I NEED A BREAK? (GOT IT?)
                }
            }else{
                System.out.println("INVALID PASSWORD: NO EMPTY FIELDS");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }while(!validPass);

        if(validPass){
            User u = new User(userName, userMail, userPass);
            this.userList.add(u);
            this.mailList.add(userMail);
            this.nameList.add(userName);
            this.passList.add(userPass);
        }

        return validPass;
    }

    public void signin(){

        boolean control = false;

        boolean matchingUser = false;
        String userMail;
        String userPass;
        do {
            System.out.println("*********************     SIGNIN     *********************");
            System.out.println("*                                                        *");
            System.out.println("*                    Insert your EMAIL                   *");
            System.out.println("*                                                        *");
            System.out.print("* >>> ");
            userMail = Input.string();
            if (userMail.trim().isEmpty()) {
                System.out.println("INVALID EMAIL: NO EMPTY FIELDS");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("*********************     SIGNIN     *********************");
                System.out.println("*                                                        *");
                System.out.println("*                  Insert your PASSWORD                  *");
                System.out.println("*                                                        *");
                System.out.print("* >>> ");
                userPass = Input.string();
                if (userPass.trim().isEmpty()) {
                    System.out.println("INVALID PASSWORD: NO EMPTY FIELDS");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    int mailIndex = mailList.indexOf(userMail);
                    int passIndex = passList.indexOf(userPass);
                    if(mailIndex == passIndex){
                        matchingUser = true;
                        loggedUi();
                    }else{
                        System.out.println("THERE IS NO USER THAT MATCHES THOSE DATA");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        control = true;
                        ui();
                    }
                }
            }
            if(control){
                System.exit(0);
            }
        } while (!matchingUser);
    }

    public boolean removeUser(User u) {
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

    public boolean removePost(Post p) {
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

    public boolean removeComment(Comment c) {
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

    public void ui() {
        boolean on = true;
        do {
            System.out.println("*********************THE SOCIAL MEDIA*********************");
            System.out.println("*                                                        *");
            System.out.println("*                   Insert '0' to EXIT                   *");
            System.out.println("*                                                        *");
            System.out.println("*                   Insert '1' to LOGIN                  *");
            System.out.println("*                                                        *");
            System.out.println("*                  Insert '2' to SIGN IN                 *");
            System.out.println("*                                                        *");
            System.out.println("*              Insert '3' to SHOW USER LIST              *");
            System.out.print("* >>> ");
            String answer = Input.string();
            switch (answer.trim()){
                case "0":
                    on = false;
                    System.exit(0);
                    break;
                case "1":
                    login();
                    break;
                case "2":
                    signin();
                    break;
                case "3":
                    System.out.println(toString());
            }
        } while (on);
    }

    public void loggedUi(){
        boolean on = true;
        do {
            System.out.println("*********************THE SOCIAL MEDIA*********************");
            System.out.println("**********************************************************");
            System.out.println("**********************YOU ARE LOGGED**********************");
            System.out.println("*                   Insert '0' to EXIT                   *");
            System.out.println("*                                                        *");
            System.out.println("*                   Insert '1' to LOGIN                  *");
            System.out.println("*                                                        *");
            System.out.println("*                  Insert '2' to SIGN IN                 *");
            System.out.println("*                                                        *");
            System.out.println("*              Insert '3' to SHOW USER LIST              *");
            System.out.print("* >>> ");
            String answer = Input.string();
            switch (answer.trim()){
                case "0":
                    on = false;
                    System.exit(0);
                    break;
                case "1":
                    login();
                    break;
                case "2":
                    signin();
                    break;
                case "3":
                    System.out.println(toString());
            }
        } while (on);
    }
}



