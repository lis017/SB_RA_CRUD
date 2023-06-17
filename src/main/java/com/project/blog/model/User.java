package com.project.blog.model;

public class User {
    private Integer userid;
    private String username;

    public User(Integer userid, String username) {  //Create
        this.userid = userid;   //this는 현재 객체(실행된놈. 원본말고)
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }   //Read

    public void setUserid(Integer userid) {         //Update
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    } //Read

    public void setUsername(String username ) {
        this.username = username;
    }   //Update
    
}
