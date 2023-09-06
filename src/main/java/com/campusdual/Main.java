package com.campusdual;

import com.campusdual.PostSupportClasses.Quality;
import com.campusdual.util.Input;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TheSocialMedia tsm = new TheSocialMedia();
        ArrayList<User> ua = new ArrayList<>();
        /*
        User u1 = new User("user1", "mail1", "pass1");

        User u2 = new User("user2", "mail2", "pass2");
        User u3 = new User("user3", "mail3", "pass3");
        User u4 = new User("user4", "mail4", "pass4");
        User u5 = new User("user5", "mail5", "pass5");

        //NOTE: THE DUMMYUSERS MAILS, NAMES AND PASSWORDS HAVEN'T BEEN ADDED TO THE PROPER LISTS SO ANOTHER USER WITH THE SAME MAIL CAN LOG IN
        ua.add(u1);
        ua.add(u2);
        ua.add(u3);
        ua.add(u4);
        ua.add(u5);
         */
        tsm.setUserList(ua);
        tsm.ui();
    }
}
