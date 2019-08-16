package com.api.model;

public class User {
    private String name;
    private String job;

    public User(){

    }

    public User(String username,String job){
        this.name = username;
        this.job = job;
    }

    public String getName(){
        return name;
    }

    public void setName(String username){
        this.name = username;
    }

    public String getJob(){
        return job;
    }

    public void setJob(String job){
        this.job = job;
    }
}
