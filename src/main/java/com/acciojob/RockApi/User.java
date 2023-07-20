package com.acciojob.RockApi;

public class User {
    private int UserId;
    private String name;
    private int age;
    private String EmailId;
    private int Mobile;
    private String country;
    public User() {
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User(int userId, String name, int age, String emailId, int mobile, String country) {
        UserId = userId;
        this.name = name;
        this.age = age;
        EmailId = emailId;
        Mobile = mobile;
        this.country = country;
    }

    public int getUserId() {
        return UserId;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getEmailId(){
        return EmailId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getMobile() {
        return Mobile;
    }
}
