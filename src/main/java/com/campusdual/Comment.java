package com.campusdual;

import java.util.Date;
import com.campusdual.User;

/**COMMENT CLASS**/
public class Comment{
    private String commentBody;
    private Date commentDate;
    private User commentUser;

    public Comment(String commentBody, Date commentDate, User commentUser) {
        this.commentBody = commentBody;
        this.commentDate = commentDate;
        this.commentUser = commentUser;
    }

    public Comment() {

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