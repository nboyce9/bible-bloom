package com.nboyce.bible_bloom.user.model;

import jakarta.persistence.Entity;

@Entity
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
