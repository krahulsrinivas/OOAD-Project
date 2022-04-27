package com.project.project;

public class User {
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.username + this.password;
    }
    
}
