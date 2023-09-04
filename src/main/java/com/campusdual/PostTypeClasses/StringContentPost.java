package com.campusdual.PostTypeClasses;

public class StringContentPost {
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
