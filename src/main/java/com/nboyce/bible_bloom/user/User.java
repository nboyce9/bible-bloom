package com.nboyce.bible_bloom.user;

public class User {
    String username;
    String email;
    String password;

    public User(){

    }
    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
