package com.church.adeprchurchmanagement.Messages;
public class message {
    private String messageheader;
    public String getMessageheader() {
        return messageheader;
    }
    private String messagename;
    public String getMessagename() {
        return messagename;
    }
    public void setMessagename(String messagename) {
        this.messagename = messagename;
    }
    public message(String messageheader, String messagename) {
        this.messageheader = messageheader;
        this.messagename = messagename;
    }
}